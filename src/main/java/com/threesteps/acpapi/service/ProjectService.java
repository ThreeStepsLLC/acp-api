package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.*;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.ProjectMapper;
import com.threesteps.acpapi.model.Project;
import com.threesteps.acpapi.repository.ProjectRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;
    private final ProjectMapper projectMapper;
    private final FileService fileService;
    private final ProjectImageService projectImageService;
    private final ProjectDetailService projectDetailService;

    public ProjectService(ProjectRepository repository,
                          ProjectMapper projectMapper,
                          FileService fileService,
                          ProjectImageService projectImageService,
                          ProjectDetailService projectDetailService) {
        this.repository = repository;
        this.projectMapper = projectMapper;
        this.fileService = fileService;
        this.projectImageService = projectImageService;
        this.projectDetailService = projectDetailService;
    }

    public List<ProjectDto> getAll() {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = projectMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public List<ProjectLangedDto> getLastLanged(String language, Integer count) {
        var entityList = count != null
                ? repository.findAllByOrderByCreateDateDesc(PageRequest.of(0, count))
                : repository.findAllByOrderByCreateDateDesc();

        return entityList
                .stream()
                .map(x -> {
                    var dto = projectMapper.toProjectLangedDto(x, language);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public Project findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find project with id: " + id));
    }

    public ProjectDto getById(String id) {
        var dto = projectMapper.toDTO(findById(id));
        dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
        return dto;
    }

    public ProjectGalleryDetailDto getDetailAndGalleryById(String id) {
        var dto = projectMapper.toProjectGalleryDetailDto(findById(id));
        dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
        dto.setGalleryImages(projectImageService.getAllByProjectId(dto.getId()));
        dto.setProjectDetails(projectDetailService.getAllByProjectId(dto.getId()));
        return dto;
    }

    public ProjectGalleryDetailLangedDto getDetailAndGalleryLangedById(String id, String language) {
        var dto = projectMapper.toProjectGalleryDetailLangedDto(findById(id), language);
        dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
        dto.setGalleryImages(projectImageService.getAllByProjectId(dto.getId()));
        dto.setProjectDetails(projectDetailService.getAllLangedByProjectId(dto.getId(), language));
        return dto;
    }

    @Transactional
    public void add(CreateProjectRequest request, MultipartFile file, List<MultipartFile> galleryImages) {
        if (file != null) {
            request.setImageUrl(fileService.saveFile(file));
        }

        request.setCreateDate(LocalDateTime.now());
        request.setStatus(true);
        var entity = repository.save(projectMapper.toDBO(request));

        if (request.getProjectDetails() != null) {
            for (var projectDetail : request.getProjectDetails()) {
                var createRequest = new CreateProjectDetailRequest(
                        projectDetail.getTitleEN(),
                        projectDetail.getTitleAZ(),
                        projectDetail.getTitleRU(),
                        projectDetail.getDescriptionEN(),
                        projectDetail.getDescriptionAZ(),
                        projectDetail.getDescriptionRU(),
                        new ProjectDto(entity.getId()));
                projectDetailService.add(createRequest);
            }
        }

        if (galleryImages != null) {
            for (var image : galleryImages) {
                var path = fileService.saveFile(image);
                var createRequest = new CreateProjectImageRequest(path,
                        new ProjectDto(entity.getId()));
                projectImageService.add(createRequest);
            }
        }

    }

    public ProjectDto update(UpdateProjectRequest request, MultipartFile file, List<MultipartFile> galleryImages) {
        var entityInDb = findById(request.getId());
        request.setImageUrl(entityInDb.getImageUrl());
        if (file != null) {
            fileService.deleteFile(request.getImageUrl());
            request.setImageUrl(fileService.saveFile(file));
        }

        if (galleryImages != null) {
            for (var image : galleryImages) {
                var path = fileService.saveFile(image);
                var createRequest = new CreateProjectImageRequest(path,
                        new ProjectDto(entityInDb.getId()));
                projectImageService.add(createRequest);
            }
        }

        if (request.getProjectDetails() != null) {
            var projectDetails = projectDetailService.getAllByProjectId(entityInDb.getId());
            projectDetails.forEach(x -> projectDetailService.deleteById(x.getId()));

            for (var projectDetail : request.getProjectDetails()) {
                var createRequest = new CreateProjectDetailRequest(
                        projectDetail.getTitleEN(),
                        projectDetail.getTitleAZ(),
                        projectDetail.getTitleRU(),
                        projectDetail.getDescriptionEN(),
                        projectDetail.getDescriptionAZ(),
                        projectDetail.getDescriptionRU(),
                        new ProjectDto(entityInDb.getId()));
                projectDetailService.add(createRequest);
            }
        }

        var entity = projectMapper.toDBO(request);
        repository.save(entity);
        return projectMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public List<ProjectLangedDto> getAllLanged(String language) {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = projectMapper.toProjectLangedDto(x, language);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public ProjectLangedDto getByIdLanged(String id, String language) {
        var dto = projectMapper.toProjectLangedDto(findById(id), language);
        dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
        return dto;
    }
}