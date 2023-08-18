package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.ProjectDetailDto;
import com.threesteps.acpapi.dto.CreateProjectDetailRequest;
import com.threesteps.acpapi.model.ProjectDetail;
import org.springframework.stereotype.Component;

@Component
public class ProjectDetailMapper {

    public ProjectDetailDto toDTO(ProjectDetail from) {
        if (from == null) return null;

        return new ProjectDetailDto(from.getId(), from.getTitle());
    }

    public ProjectDetail toDBO(CreateProjectDetailRequest from) {
        if (from == null) return null;

        return new ProjectDetail(null, from.getTitle());
    }

    public ProjectDetail toDBO(ProjectDetailDto from) {
        if (from == null) return null;

        return new ProjectDetail(from.getId(), from.getTitle());
    }

}