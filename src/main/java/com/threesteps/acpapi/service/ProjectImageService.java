package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.ProjectImageDto;
import com.threesteps.acpapi.dto.CreateProjectImageRequest;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.ProjectImageMapper;
import com.threesteps.acpapi.model.ProjectImage;
import com.threesteps.acpapi.repository.ProjectImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectImageService {

    private final ProjectImageRepository repository;
    private final ProjectImageMapper projectImageMapper;

    public ProjectImageService(ProjectImageRepository repository, ProjectImageMapper projectImageMapper) {
        this.repository = repository;
        this.projectImageMapper = projectImageMapper;
    }

    public List<ProjectImageDto> getAll() {
        return repository.findAll()
                .stream()
                .map(projectImageMapper::toDTO)
                .toList();
    }

    public ProjectImage findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find projectImage with id: " + id));
    }

    public ProjectImageDto getById(String id) {
        return projectImageMapper.toDTO(findById(id));
    }

    public void add(CreateProjectImageRequest request) {
        repository.save(projectImageMapper.toDBO(request));
    }

    public ProjectImageDto update(ProjectImageDto projectImageDto) {
        var entity = projectImageMapper.toDBO(projectImageDto);
        repository.save(entity);
        return projectImageMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}