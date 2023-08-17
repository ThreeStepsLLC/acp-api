package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.UserPermissionDto;
import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreateUserPermissionRequest;
import com.threesteps.acpapi.service.UserPermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-permissions")
public class UserPermissionController {

    private final UserPermissionService userPermissionService;

    public UserPermissionController(UserPermissionService userPermissionService) {
        this.userPermissionService = userPermissionService;
    }

    @GetMapping
    public ApiResponseDto<List<UserPermissionDto>> getAll() {
        return new ApiResponseDto<>(userPermissionService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<UserPermissionDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(userPermissionService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<List<UserPermissionDto>> add(@RequestBody CreateUserPermissionRequest request) {
        return new ApiResponseDto<>(userPermissionService.add(request));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<List<UserPermissionDto>> deleteById(@PathVariable String id) {
        return new ApiResponseDto<>(userPermissionService.deleteById(id));
    }

}