package com.threesteps.acpapi.controller.admin;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreatePositionRequest;
import com.threesteps.acpapi.dto.PositionDto;
import com.threesteps.acpapi.service.PositionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-positions")
public class AdminPositionController {

    private final PositionService positionService;

    public AdminPositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public ApiResponseDto<List<PositionDto>> getAll() {
        return new ApiResponseDto<>(positionService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<PositionDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(positionService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@RequestBody CreatePositionRequest request) {
        positionService.add(request);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<PositionDto> update(@RequestBody PositionDto positionDto) {
        return new ApiResponseDto<>(positionService.update(positionDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        positionService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}