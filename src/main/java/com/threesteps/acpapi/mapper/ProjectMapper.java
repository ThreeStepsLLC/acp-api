package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.ProjectDto;
import com.threesteps.acpapi.dto.CreateProjectRequest;
import com.threesteps.acpapi.dto.ProjectLangedDto;
import com.threesteps.acpapi.model.Project;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProjectMapper {

    public ProjectDto toDTO(Project from) {
        if (from == null) return null;

        return new ProjectDto(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getAddressEN(),
                from.getAddressAZ(),
                from.getAddressRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public Project toDBO(CreateProjectRequest from) {
        if (from == null) return null;

        return new Project(null,
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getAddressEN(),
                from.getAddressAZ(),
                from.getAddressRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public Project toDBO(ProjectDto from) {
        if (from == null) return null;

        return new Project(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getAddressEN(),
                from.getAddressAZ(),
                from.getAddressRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public ProjectLangedDto toProjectLangedDto(Project from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new ProjectLangedDto(from.getId(),
                    from.getTitleAZ(),
                    from.getDescriptionAZ(),
                    from.getAddressAZ(),
                    from.getImageUrl(),
                    from.getCreateDate(),
                    from.getStatus());
        }

        if (Objects.equals(language, "ru")) {
            return new ProjectLangedDto(from.getId(),
                    from.getTitleRU(),
                    from.getDescriptionRU(),
                    from.getAddressRU(),
                    from.getImageUrl(),
                    from.getCreateDate(),
                    from.getStatus());
        }

        return new ProjectLangedDto(from.getId(),
                from.getTitleEN(),
                from.getDescriptionEN(),
                from.getAddressEN(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());

    }

}