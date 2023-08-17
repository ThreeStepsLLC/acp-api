package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.ConstantDto;
import com.threesteps.acpapi.service.ConstantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-constants")
public class AdminConstantController {

    private final ConstantService constantService;

    public AdminConstantController(ConstantService constantService) {
        this.constantService = constantService;
    }

    @GetMapping
    public ApiResponseDto<List<ConstantDto>> getAll() {
        return new ApiResponseDto<>(constantService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<ConstantDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(constantService.getById(id));
    }

    @PutMapping
    public ApiResponseDto<ConstantDto> update(@RequestBody ConstantDto constantDto) {
        return new ApiResponseDto<>(constantService.update(constantDto));
    }

}
