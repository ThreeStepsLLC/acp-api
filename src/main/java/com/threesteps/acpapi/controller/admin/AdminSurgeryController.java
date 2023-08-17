package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreateSurgeryRequest;
import com.threesteps.acpapi.dto.SurgeryDto;
import com.threesteps.acpapi.service.SurgeryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-surgeries")
public class AdminSurgeryController {

    private final SurgeryService surgeryService;

    public AdminSurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @GetMapping
    public ApiResponseDto<List<SurgeryDto>> getAll() {
        return new ApiResponseDto<>(surgeryService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<SurgeryDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(surgeryService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@RequestBody CreateSurgeryRequest request) {
        surgeryService.add(request);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<SurgeryDto> update(@RequestBody SurgeryDto surgeryDto) {
        return new ApiResponseDto<>(surgeryService.update(surgeryDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        surgeryService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}