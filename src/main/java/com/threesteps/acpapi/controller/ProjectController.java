package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.ProjectLangedDto;
import com.threesteps.acpapi.service.ProjectService;
import com.threesteps.acpapi.service.helper.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final LanguageService languageService;

    public ProjectController(ProjectService projectService, LanguageService languageService) {
        this.projectService = projectService;
        this.languageService = languageService;
    }

    @GetMapping
    public ApiResponseDto<List<ProjectLangedDto>> getAll() {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(projectService.getAllLanged(language));
    }

    @GetMapping("/last-langed")
    public ApiResponseDto<List<ProjectLangedDto>> getLastLanged() {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(projectService.getLastLanged(language));
    }

    @GetMapping("/{id}")
    public ApiResponseDto<ProjectLangedDto> getByIdLanged(@PathVariable String id) {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(projectService.getByIdLanged(id, language));
    }

}
