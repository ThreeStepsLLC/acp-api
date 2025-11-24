package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ServiceItemDto;
import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreateServiceItemRequest;
import com.threesteps.acpapi.service.ServiceItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-services")
public class AdminServiceItemController {

    private final ServiceItemService serviceItemService;

    public AdminServiceItemController(ServiceItemService serviceItemService) {
        this.serviceItemService = serviceItemService;
    }

    @GetMapping
    public ApiResponseDto<List<ServiceItemDto>> getAll() {
        return new ApiResponseDto<>(serviceItemService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<ServiceItemDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(serviceItemService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@ModelAttribute CreateServiceItemRequest request,
                                 @RequestParam(name = "file", required = false) MultipartFile file) {
        serviceItemService.add(request, file);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<ServiceItemDto> update(@ModelAttribute ServiceItemDto serviceItemDto,
                                                 @RequestParam(name = "file", required = false) MultipartFile file) {
        return new ApiResponseDto<>(serviceItemService.update(serviceItemDto, file));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        serviceItemService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}
