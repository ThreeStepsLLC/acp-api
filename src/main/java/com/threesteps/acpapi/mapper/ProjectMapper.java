package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.*;
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
                from.getProgress(),
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
                from.getProgress(),
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
                from.getProgress(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public ProjectGalleryDetailDto toProjectGalleryDetailDto(Project from) {
        if (from == null) return null;

        return new ProjectGalleryDetailDto(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getAddressEN(),
                from.getAddressAZ(),
                from.getAddressRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getProgress(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus(),
                null,
                null);
    }

    public ProjectLangedDto toProjectLangedDto(Project from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new ProjectLangedDto(from.getId(),
                    from.getTitleAZ(),
                    from.getAddressAZ(),
                    from.getDescriptionAZ(),
                    from.getImageUrl(),
                    from.getProgress(),
                    from.getCreateDate(),
                    from.getStatus());
        }

        if (Objects.equals(language, "ru")) {
            return new ProjectLangedDto(from.getId(),
                    from.getTitleRU(),
                    from.getAddressRU(),
                    from.getDescriptionRU(),
                    from.getImageUrl(),
                    from.getProgress(),
                    from.getCreateDate(),
                    from.getStatus());
        }

        return new ProjectLangedDto(from.getId(),
                from.getTitleEN(),
                from.getAddressEN(),
                from.getDescriptionEN(),
                from.getImageUrl(),
                from.getProgress(),
                from.getCreateDate(),
                from.getStatus());

    }

    public ProjectGalleryDetailLangedDto toProjectGalleryDetailLangedDto(Project from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new ProjectGalleryDetailLangedDto(from.getId(),
                    from.getTitleAZ(),
                    from.getAddressAZ(),
                    from.getDescriptionAZ(),
                    from.getProgress(),
                    from.getImageUrl(),
                    from.getCreateDate(),
                    from.getStatus(),
                    null,
                    null);
        }

        if (Objects.equals(language, "ru")) {
            return new ProjectGalleryDetailLangedDto(from.getId(),
                    from.getTitleRU(),
                    from.getAddressRU(),
                    from.getDescriptionRU(),
                    from.getProgress(),
                    from.getImageUrl(),
                    from.getCreateDate(),
                    from.getStatus(),
                    null,
                    null);
        }

        return new ProjectGalleryDetailLangedDto(from.getId(),
                from.getTitleEN(),
                from.getAddressEN(),
                from.getDescriptionEN(),
                from.getProgress(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus(),
                null,
                null);
    }

    public Project toDBO(UpdateProjectRequest from) {
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
                from.getProgress(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }
}