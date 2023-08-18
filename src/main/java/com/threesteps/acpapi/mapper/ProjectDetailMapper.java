package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.CreateProjectDetailRequest;
import com.threesteps.acpapi.dto.ProjectDetailDto;
import com.threesteps.acpapi.dto.ProjectDetailLangedDto;
import com.threesteps.acpapi.dto.ProjectDto;
import com.threesteps.acpapi.model.ProjectDetail;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProjectDetailMapper {

    private final ProjectMapper projectMapper;

    public ProjectDetailMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    public ProjectDetailDto toDTO(ProjectDetail from) {
        if (from == null) return null;

        return new ProjectDetailDto(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                projectMapper.toDTO(from.getProject()));
    }

    public ProjectDetail toDBO(CreateProjectDetailRequest from) {
        if (from == null) return null;

        return new ProjectDetail(null,
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                projectMapper.toDBO(new ProjectDto(from.getProject().getId())));
    }

    public ProjectDetail toDBO(ProjectDetailDto from) {
        if (from == null) return null;

        return new ProjectDetail(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                projectMapper.toDBO(from.getProject()));
    }

    public ProjectDetailLangedDto toConstantLangedDto(ProjectDetail from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new ProjectDetailLangedDto(
                    from.getId(),
                    from.getTitleAZ(),
                    from.getDescriptionAZ(),
                    projectMapper.toDTO(from.getProject())
            );
        }

        if (Objects.equals(language, "ru")) {
            return new ProjectDetailLangedDto(
                    from.getId(),
                    from.getTitleRU(),
                    from.getDescriptionRU(),
                    projectMapper.toDTO(from.getProject())
            );
        }

        return new ProjectDetailLangedDto(
                from.getId(),
                from.getTitleEN(),
                from.getDescriptionEN(),
                projectMapper.toDTO(from.getProject())
        );
    }

}