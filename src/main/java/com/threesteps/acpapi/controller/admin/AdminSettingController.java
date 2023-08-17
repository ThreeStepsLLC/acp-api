package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.SettingDto;
import com.threesteps.acpapi.service.SettingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin-settings")
public class AdminSettingController {

    private final SettingService settingService;

    public AdminSettingController(SettingService settingService) {
        this.settingService = settingService;
    }

    @GetMapping
    public ApiResponseDto<SettingDto> getAll() {
        return new ApiResponseDto<>(settingService.get());
    }

    @PutMapping
    public ApiResponseDto<SettingDto> update(@RequestBody SettingDto settingDto) {
        return new ApiResponseDto<>(settingService.update(settingDto));
    }

}
