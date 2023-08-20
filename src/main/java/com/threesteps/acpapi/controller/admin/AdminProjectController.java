package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreateProjectRequest;
import com.threesteps.acpapi.dto.ProjectDto;
import com.threesteps.acpapi.dto.ProjectGalleryDetailDto;
import com.threesteps.acpapi.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-projects")
public class AdminProjectController {

    private final ProjectService projectService;

    public AdminProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ApiResponseDto<List<ProjectDto>> getAll() {
        return new ApiResponseDto<>(projectService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<ProjectGalleryDetailDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(projectService.getDetailAndGalleryById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@ModelAttribute CreateProjectRequest request,
                                 @RequestParam(name = "file") MultipartFile file,
                                 @RequestParam(name = "galleryImages", required = false) List<MultipartFile> galleryImages) {
        projectService.add(request, file, galleryImages);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<ProjectDto> update(@ModelAttribute ProjectDto projectDto,
                                             @RequestParam(name = "file", required = false) MultipartFile file,
                                             @RequestParam(name = "galleryImages", required = false) List<MultipartFile> galleryImages) {
        return new ApiResponseDto<>(projectService.update(projectDto, file, galleryImages));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        projectService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}