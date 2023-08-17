package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.GalleryDto;
import com.threesteps.acpapi.dto.CreateGalleryRequest;
import com.threesteps.acpapi.model.Gallery;
import org.springframework.stereotype.Component;

@Component
public class GalleryMapper {

    public GalleryDto toDTO(Gallery from) {
        if (from == null) return null;

        return new GalleryDto(from.getId(),
                from.getTitle(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public Gallery toDBO(CreateGalleryRequest from) {
        if (from == null) return null;

        return new Gallery(null,
                from.getTitle(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public Gallery toDBO(GalleryDto from) {
        if (from == null) return null;

        return new Gallery(from.getId(),
                from.getTitle(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

}