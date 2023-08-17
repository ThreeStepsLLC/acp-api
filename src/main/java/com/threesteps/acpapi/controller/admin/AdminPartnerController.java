package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.PartnerDto;
import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreatePartnerRequest;
import com.threesteps.acpapi.service.PartnerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-partners")
public class AdminPartnerController {

    private final PartnerService partnerService;

    public AdminPartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    public ApiResponseDto<List<PartnerDto>> getAll() {
        return new ApiResponseDto<>(partnerService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<PartnerDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(partnerService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@ModelAttribute CreatePartnerRequest request,
                                 @RequestParam(name = "file") MultipartFile file) {
        partnerService.add(request, file);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<PartnerDto> update(@ModelAttribute PartnerDto partnerDto,
                                                 @RequestParam(name = "file") MultipartFile file) {
        return new ApiResponseDto<>(partnerService.update(partnerDto, file));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        partnerService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}