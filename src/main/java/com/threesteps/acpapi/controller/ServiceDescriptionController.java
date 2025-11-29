package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.ServiceDescriptionDto;
import com.threesteps.acpapi.service.ServiceDescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/services-description")
public class ServiceDescriptionController {

    private final ServiceDescriptionService service;

    public ServiceDescriptionController(ServiceDescriptionService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponseDto<ServiceDescriptionDto> get() {
        return new ApiResponseDto<>(service.get());
    }

}
