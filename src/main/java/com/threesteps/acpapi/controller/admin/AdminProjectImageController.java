package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ProjectImageDto;
import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreateProjectImageRequest;
import com.threesteps.acpapi.service.ProjectImageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-project-images")
public class AdminProjectImageController {

    private final ProjectImageService projectImageService;

    public AdminProjectImageController(ProjectImageService projectImageService) {
        this.projectImageService = projectImageService;
    }

    @GetMapping
    public ApiResponseDto<List<ProjectImageDto>> getAll() {
        return new ApiResponseDto<>(projectImageService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<ProjectImageDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(projectImageService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@RequestBody CreateProjectImageRequest request) {
        projectImageService.add(request);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<ProjectImageDto> update(@RequestBody ProjectImageDto projectImageDto) {
        return new ApiResponseDto<>(projectImageService.update(projectImageDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        projectImageService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}