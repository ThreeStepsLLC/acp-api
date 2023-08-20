package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.SliderImageDto;
import com.threesteps.acpapi.service.SliderImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/slider-images")
public class SliderImageController {

    private final SliderImageService sliderImageService;

    public SliderImageController(SliderImageService sliderImageService) {
        this.sliderImageService = sliderImageService;
    }

    @GetMapping
    public ApiResponseDto<List<SliderImageDto>> getAll() {
        return new ApiResponseDto<>(sliderImageService.getAll());
    }
}