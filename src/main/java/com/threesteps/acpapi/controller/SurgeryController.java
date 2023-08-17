package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.SurgeryLangedDto;
import com.threesteps.acpapi.service.SurgeryService;
import com.threesteps.acpapi.service.helper.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/surgeries")
public class SurgeryController {

    private final SurgeryService surgeryService;
    private final LanguageService languageService;

    public SurgeryController(SurgeryService surgeryService,
                             LanguageService languageService) {
        this.surgeryService = surgeryService;
        this.languageService = languageService;
    }

    @GetMapping
    public ApiResponseDto<List<SurgeryLangedDto>> getAll() {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(surgeryService.getAllLanged(language));
    }

    @GetMapping("/{id}")
    public ApiResponseDto<SurgeryLangedDto> getById(@PathVariable String id) {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(surgeryService.getByIdLanged(id, language));
    }
}
