package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ProjectDetailDto;
import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreateProjectDetailRequest;
import com.threesteps.acpapi.service.ProjectDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project_detail")
public class ProjectDetailController {

    private final ProjectDetailService projectDetailService;

    public ProjectDetailController(ProjectDetailService projectDetailService) {
        this.projectDetailService = projectDetailService;
    }

    @GetMapping
    public ApiResponseDto<List<ProjectDetailDto>> getAll() {
        return new ApiResponseDto<>(projectDetailService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<ProjectDetailDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(projectDetailService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@RequestBody CreateProjectDetailRequest request) {
        projectDetailService.add(request);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<ProjectDetailDto> update(@RequestBody ProjectDetailDto projectDetailDto) {
        return new ApiResponseDto<>(projectDetailService.update(projectDetailDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        projectDetailService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}