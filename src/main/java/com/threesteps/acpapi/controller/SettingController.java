package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.SettingDto;
import com.threesteps.acpapi.service.SettingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/settings")
public class SettingController {

    private final SettingService settingService;

    public SettingController(SettingService settingService) {
        this.settingService = settingService;
    }

    @GetMapping
    public ApiResponseDto<SettingDto> get() {
        return new ApiResponseDto<>(settingService.get());
    }


}