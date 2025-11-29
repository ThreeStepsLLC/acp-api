package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.ServiceDescriptionDto;
import com.threesteps.acpapi.service.ServiceDescriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin-services-description")
public class AdminServiceDescriptionController {

    private final ServiceDescriptionService service;

    public AdminServiceDescriptionController(ServiceDescriptionService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponseDto<ServiceDescriptionDto> get() {
        return new ApiResponseDto<>(service.get());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<ServiceDescriptionDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(service.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> create(@RequestBody ServiceDescriptionDto dto) {
        service.create(dto);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<ServiceDescriptionDto> update(@RequestBody ServiceDescriptionDto dto) {
        return new ApiResponseDto<>(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> delete(@PathVariable String id) {
        service.delete(id);
        return new ApiResponseDto<>(null);
    }

}
