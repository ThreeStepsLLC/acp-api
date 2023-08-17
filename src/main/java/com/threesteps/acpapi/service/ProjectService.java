package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.ProjectDto;
import com.threesteps.acpapi.dto.CreateProjectRequest;
import com.threesteps.acpapi.dto.ProjectLangedDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.ProjectMapper;
import com.threesteps.acpapi.model.Project;
import com.threesteps.acpapi.repository.ProjectRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
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

    public ProjectService(ProjectRepository repository,
                          ProjectMapper projectMapper,
                          FileService fileService) {
        this.repository = repository;
        this.projectMapper = projectMapper;
        this.fileService = fileService;
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
        return count != null
                ? repository
                .findAllByOrderByCreateDateDesc(PageRequest.of(0, count))
                .stream()
                .map(x -> {
                    var dto = projectMapper.toProjectLangedDto(x, language);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList()

                : repository
                .findAllByOrderByCreateDateDesc()
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

    public void add(CreateProjectRequest request, MultipartFile file) {
        if (file != null) {
            request.setImageUrl(fileService.saveFile(file));
        }

        request.setCreateDate(LocalDateTime.now());
        request.setStatus(true);
        repository.save(projectMapper.toDBO(request));
    }

    public ProjectDto update(ProjectDto projectDto, MultipartFile file) {
        var entityInDb = findById(projectDto.getId());
        projectDto.setImageUrl(entityInDb.getImageUrl());
        if (file != null) {
            fileService.deleteFile(projectDto.getImageUrl());
            projectDto.setImageUrl(fileService.saveFile(file));
        }

        var entity = projectMapper.toDBO(projectDto);
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