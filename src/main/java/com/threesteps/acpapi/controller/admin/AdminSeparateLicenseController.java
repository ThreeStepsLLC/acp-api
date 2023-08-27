package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.SeparateLicenseDto;
import com.threesteps.acpapi.service.SeparateLicenseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-separate-licenses")
public class AdminSeparateLicenseController {

    private final SeparateLicenseService separateLicenseService;

    public AdminSeparateLicenseController(SeparateLicenseService separateLicenseService) {
        this.separateLicenseService = separateLicenseService;
    }

    @GetMapping
    public ApiResponseDto<List<SeparateLicenseDto>> getAll() {
        return new ApiResponseDto<>(separateLicenseService.getAll());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@RequestParam(name = "file") MultipartFile file) {
        separateLicenseService.add(file);
        return new ApiResponseDto<>(null);
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        separateLicenseService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}