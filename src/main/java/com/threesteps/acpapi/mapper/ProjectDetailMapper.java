package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.*;
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

    public ProjectDetailViewDto toProjectDetailViewDto(ProjectDetail from) {
        if (from == null) return null;

        return new ProjectDetailViewDto(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU());
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

    public ProjectDetailLangedDto toProjectDetailLangedDto(ProjectDetail from, String language) {
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

    public ProjectDetailLangedViewDto toProjectDetailLangedViewDto(ProjectDetail from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new ProjectDetailLangedViewDto(
                    from.getId(),
                    from.getTitleAZ(),
                    from.getDescriptionAZ());
        }

        if (Objects.equals(language, "ru")) {
            return new ProjectDetailLangedViewDto(
                    from.getId(),
                    from.getTitleRU(),
                    from.getDescriptionRU()
            );
        }

        return new ProjectDetailLangedViewDto(
                from.getId(),
                from.getTitleEN(),
                from.getDescriptionEN());
    }

}