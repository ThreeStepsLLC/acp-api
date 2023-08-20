package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.ProjectDto;
import com.threesteps.acpapi.dto.ProjectImageDto;
import com.threesteps.acpapi.dto.CreateProjectImageRequest;
import com.threesteps.acpapi.dto.ProjectImageViewDto;
import com.threesteps.acpapi.model.ProjectImage;
import org.springframework.stereotype.Component;

@Component
public class ProjectImageMapper {

    private final ProjectMapper projectMapper;

    public ProjectImageMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    public ProjectImageDto toDTO(ProjectImage from) {
        if (from == null) return null;

        return new ProjectImageDto(from.getId(),
                from.getPath(),
                projectMapper.toDTO(from.getProject()));
    }

    public ProjectImage toDBO(CreateProjectImageRequest from) {
        if (from == null) return null;

        return new ProjectImage(null,
                from.getPath(),
                projectMapper.toDBO(new ProjectDto(from.getProject().getId())));
    }

    public ProjectImage toDBO(ProjectImageDto from) {
        if (from == null) return null;


        return new ProjectImage(from.getId(),
                from.getPath(),
                projectMapper.toDBO(from.getProject()));
    }

    public ProjectImageViewDto toProjectImageViewDto(ProjectImage from) {
        if (from == null) return null;


        return new ProjectImageViewDto(from.getId(),
                from.getPath());
    }

}