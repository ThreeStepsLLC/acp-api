package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.PositionLangedDto;
import com.threesteps.acpapi.service.PositionService;
import com.threesteps.acpapi.service.helper.LanguageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/positions")
public class PositionController {

    private final PositionService positionService;
    private final LanguageService languageService;

    public PositionController(PositionService positionService, LanguageService languageService) {
        this.positionService = positionService;
        this.languageService = languageService;
    }

    @GetMapping
    public ApiResponseDto<List<PositionLangedDto>> getAll() {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(positionService.getAllLanged(language));
    }

}