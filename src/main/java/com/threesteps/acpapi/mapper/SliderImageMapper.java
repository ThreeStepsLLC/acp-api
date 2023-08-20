package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.SliderImageDto;
import com.threesteps.acpapi.dto.CreateSliderImageRequest;
import com.threesteps.acpapi.model.SliderImage;
import org.springframework.stereotype.Component;

@Component
public class SliderImageMapper {

    public SliderImageDto toDTO(SliderImage from) {
        if (from == null) return null;

        return new SliderImageDto(from.getId(), from.getImageUrl());
    }

    public SliderImage toDBO(CreateSliderImageRequest from) {
        if (from == null) return null;

        return new SliderImage(null, from.getImageUrl());
    }

    public SliderImage toDBO(SliderImageDto from) {
        if (from == null) return null;

        return new SliderImage(from.getId(), from.getImageUrl());
    }

}