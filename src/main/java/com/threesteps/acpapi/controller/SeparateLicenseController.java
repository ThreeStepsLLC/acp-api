package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.SeparateLicenseDto;
import com.threesteps.acpapi.service.SeparateLicenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/separate-licenses")
public class SeparateLicenseController {

    private final SeparateLicenseService separateLicenseService;

    public SeparateLicenseController(SeparateLicenseService separateLicenseService) {
        this.separateLicenseService = separateLicenseService;
    }

    @GetMapping
    public ApiResponseDto<List<SeparateLicenseDto>> getAll() {
        return new ApiResponseDto<>(separateLicenseService.getAll());
    }
}