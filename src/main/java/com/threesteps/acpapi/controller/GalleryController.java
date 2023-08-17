package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.GalleryDto;
import com.threesteps.acpapi.service.GalleryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/galleries")
public class GalleryController {

    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping
    public ApiResponseDto<List<GalleryDto>> getAll() {
        return new ApiResponseDto<>(galleryService.getAllLast());
    }

    @GetMapping("/count")
    public ApiResponseDto<List<GalleryDto>> getLastLanged(@RequestParam int count) {
        return new ApiResponseDto<>(galleryService.getLast(count));
    }

}
