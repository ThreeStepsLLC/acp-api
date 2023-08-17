package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.*;
import com.threesteps.acpapi.service.AuthService;
import com.threesteps.acpapi.service.UserPermissionService;
import com.threesteps.acpapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-auth")
public class AdminAuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserPermissionService userPermissionService;

    public AdminAuthController(AuthService authService,
                               UserService userService,
                               UserPermissionService userPermissionService) {
        this.authService = authService;
        this.userService = userService;
        this.userPermissionService = userPermissionService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<TokenResponseDto> login(@RequestBody LoginDto loginDto) {
        return new ApiResponseDto<>(authService.login(loginDto));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<TokenResponseDto> register(@RequestBody RegisterRequest request) {
        return new ApiResponseDto<>(authService.register(request));
    }

    @GetMapping("/users")
    public ApiResponseDto<List<UserDto>> getAllUsers() {
        return new ApiResponseDto<>(userService.getAll());
    }

    @PutMapping("update-password")
    public ApiResponseDto updatePassword(@RequestBody UpdatePasswordRequest request) {
        userService.updatePassword(request);
        return new ApiResponseDto(null);
    }

    @GetMapping("/users/{userId}/permissions")
    public ApiResponseDto<List<PermissionDto>> getUserPermissions(@PathVariable String userId) {
        return new ApiResponseDto<>(userPermissionService.getPermissionsByUserId(userId));
    }

    @PostMapping("/add-permission")
    public ApiResponseDto addPermission(@RequestBody UserPermissionManyRequest request) {
        userPermissionService.updatePermissions(request);
        return new ApiResponseDto<>(null);
    }

    @PostMapping("/add-user")
    public ApiResponseDto addUser(@RequestBody RegisterRequest request) {
        authService.register(request);
        return new ApiResponseDto<>(null);
    }


}
