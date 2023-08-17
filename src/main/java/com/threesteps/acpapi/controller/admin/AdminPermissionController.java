package com.threesteps.acpapi.controller.admin;


import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.PermissionDto;
import com.threesteps.acpapi.service.PermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-permissions")
public class AdminPermissionController {

    private final PermissionService permissionService;

    public AdminPermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    public ApiResponseDto<List<PermissionDto>> getById() {
        return new ApiResponseDto<>(permissionService.getAll());
    }

}
