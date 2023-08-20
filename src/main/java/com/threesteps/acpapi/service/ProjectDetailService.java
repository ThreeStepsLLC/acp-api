package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.*;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.ProjectDetailMapper;
import com.threesteps.acpapi.model.ProjectDetail;
import com.threesteps.acpapi.repository.ProjectDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDetailService {

    private final ProjectDetailRepository repository;
    private final ProjectDetailMapper projectDetailMapper;

    public ProjectDetailService(ProjectDetailRepository repository, ProjectDetailMapper projectDetailMapper) {
        this.repository = repository;
        this.projectDetailMapper = projectDetailMapper;
    }

    public List<ProjectDetailDto> getAll() {
        return repository.findAll()
                .stream()
                .map(projectDetailMapper::toDTO)
                .toList();
    }

    public List<ProjectDetailViewDto> getAllByProjectId(String projectId) {
        return repository.findAllByProjectId(projectId)
                .stream()
                .map(projectDetailMapper::toProjectDetailViewDto)
                .toList();
    }

    public List<ProjectDetailLangedViewDto> getAllLangedByProjectId(String projectId, String language) {
        return repository.findAllByProjectId(projectId)
                .stream()
                .map(x -> projectDetailMapper.toProjectDetailLangedViewDto(x, language))
                .toList();
    }

    public ProjectDetail findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find projectDetail with id: " + id));
    }

    public ProjectDetailDto getById(String id) {
        return projectDetailMapper.toDTO(findById(id));
    }

    public void add(CreateProjectDetailRequest request) {
        repository.save(projectDetailMapper.toDBO(request));
    }

    public ProjectDetailDto update(ProjectDetailDto projectDetailDto) {
        var entity = projectDetailMapper.toDBO(projectDetailDto);
        repository.save(entity);
        return projectDetailMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}