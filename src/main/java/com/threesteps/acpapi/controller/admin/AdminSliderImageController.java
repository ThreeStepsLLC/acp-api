package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.SliderImageDto;
import com.threesteps.acpapi.service.SliderImageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-slider-images")
public class AdminSliderImageController {

    private final SliderImageService sliderImageService;

    public AdminSliderImageController(SliderImageService sliderImageService) {
        this.sliderImageService = sliderImageService;
    }

    @GetMapping
    public ApiResponseDto<List<SliderImageDto>> getAll() {
        return new ApiResponseDto<>(sliderImageService.getAll());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@RequestParam(name = "file") MultipartFile file) {
        sliderImageService.add(file);
        return new ApiResponseDto<>(null);
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        sliderImageService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}