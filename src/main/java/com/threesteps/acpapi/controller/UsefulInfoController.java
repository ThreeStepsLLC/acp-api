package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.UsefulInfoLangedDto;
import com.threesteps.acpapi.service.UsefulInfoService;
import com.threesteps.acpapi.service.helper.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/useful-infos")
public class UsefulInfoController {

    private final UsefulInfoService usefulInfoService;
    private final LanguageService languageService;

    public UsefulInfoController(UsefulInfoService usefulInfoService, LanguageService languageService) {
        this.usefulInfoService = usefulInfoService;
        this.languageService = languageService;
    }

    @GetMapping
    public ApiResponseDto<List<UsefulInfoLangedDto>> getAll() {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(usefulInfoService.getAllLanged(language));
    }

    @GetMapping("/last-langed")
    public ApiResponseDto<List<UsefulInfoLangedDto>> getLastLanged() {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(usefulInfoService.getLastLanged(language));
    }

    @GetMapping("/{id}")
    public ApiResponseDto<UsefulInfoLangedDto> getByIdLanged(@PathVariable String id) {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(usefulInfoService.getByIdLanged(id, language));
    }

}
