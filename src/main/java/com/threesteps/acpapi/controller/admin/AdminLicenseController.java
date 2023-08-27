package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.LicenseDto;
import com.threesteps.acpapi.service.LicenseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-licenses")
public class AdminLicenseController {

    private final LicenseService licenseService;

    public AdminLicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping
    public ApiResponseDto<List<LicenseDto>> getAll() {
        return new ApiResponseDto<>(licenseService.getAll());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@RequestParam(name = "file") MultipartFile file) {
        licenseService.add(file);
        return new ApiResponseDto<>(null);
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        licenseService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}