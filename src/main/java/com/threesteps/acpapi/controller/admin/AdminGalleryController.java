package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.GalleryDto;
import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreateGalleryRequest;
import com.threesteps.acpapi.service.GalleryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-galleries")
public class AdminGalleryController {

    private final GalleryService galleryService;

    public AdminGalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping
    public ApiResponseDto<List<GalleryDto>> getAll() {
        return new ApiResponseDto<>(galleryService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<GalleryDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(galleryService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@ModelAttribute CreateGalleryRequest request,
                                 @RequestParam(name = "file") MultipartFile file) {
        galleryService.add(request, file);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<GalleryDto> update(@ModelAttribute GalleryDto galleryDto,
                                                 @RequestParam(name = "file") MultipartFile file) {
        return new ApiResponseDto<>(galleryService.update(galleryDto, file));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        galleryService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}