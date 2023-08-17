package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.UserDto;
import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreateUserRequest;
import com.threesteps.acpapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ApiResponseDto<List<UserDto>> getAll() {
        return new ApiResponseDto<>(userService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<UserDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<List<UserDto>> deleteById(@PathVariable String id) {
        return new ApiResponseDto<>(userService.deleteById(id));
    }

}