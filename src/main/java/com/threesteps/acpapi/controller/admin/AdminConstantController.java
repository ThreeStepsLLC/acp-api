package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.ConstantDto;
import com.threesteps.acpapi.service.ConstantService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/admin-constants")
public class AdminConstantController {

    private final ConstantService constantService;

    public AdminConstantController(ConstantService constantService) {
        this.constantService = constantService;
    }

    @GetMapping("/{id}")
    public ApiResponseDto<ConstantDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(constantService.getById(id));
    }

    @PutMapping
    public ApiResponseDto<ConstantDto> update(@ModelAttribute ConstantDto constantDto,
                                              @RequestParam(name = "file", required = false) MultipartFile file,
                                              @RequestParam(name = "media1", required = false) MultipartFile media1,
                                              @RequestParam(name = "media2", required = false) MultipartFile media2) {
        return new ApiResponseDto<>(constantService.update(constantDto, file, media1, media2));
    }

}
