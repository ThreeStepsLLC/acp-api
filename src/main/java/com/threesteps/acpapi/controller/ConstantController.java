package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.ConstantDto;
import com.threesteps.acpapi.dto.ConstantLangedDto;
import com.threesteps.acpapi.service.ConstantService;
import com.threesteps.acpapi.service.helper.LanguageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/constants")
public class ConstantController {

    private final ConstantService constantService;
    private final LanguageService languageService;

    public ConstantController(ConstantService constantService,
                              LanguageService languageService) {
        this.constantService = constantService;
        this.languageService = languageService;
    }

    @GetMapping("/{id}/langed")
    public ApiResponseDto<ConstantLangedDto> getConstantByIdLanged(@PathVariable String id) {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(constantService.getConstantByIdLanged(id, language));
    }

    @GetMapping("/{id}")
    public ApiResponseDto<ConstantDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(constantService.getById(id));
    }

}