package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreateUsefulInfoRequest;
import com.threesteps.acpapi.dto.UsefulInfoDto;
import com.threesteps.acpapi.service.UsefulInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-useful-infos")
public class AdminUsefulInfoController {

    private final UsefulInfoService usefulInfoService;

    public AdminUsefulInfoController(UsefulInfoService usefulInfoService) {
        this.usefulInfoService = usefulInfoService;
    }

    @GetMapping
    public ApiResponseDto<List<UsefulInfoDto>> getAll() {
        return new ApiResponseDto<>(usefulInfoService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<UsefulInfoDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(usefulInfoService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@ModelAttribute CreateUsefulInfoRequest request,
                                 @RequestParam(name = "file") MultipartFile file) {
        usefulInfoService.add(request, file);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<UsefulInfoDto> update(@ModelAttribute UsefulInfoDto usefulInfoDto,
                                                @RequestParam(name = "file", required = false) MultipartFile file) {
        return new ApiResponseDto<>(usefulInfoService.update(usefulInfoDto, file));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        usefulInfoService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}