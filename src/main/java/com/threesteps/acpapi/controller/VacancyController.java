package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.VacancyDto;
import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.CreateVacancyRequest;
import com.threesteps.acpapi.service.VacancyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vacancies")
public class VacancyController {

    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping
    public ApiResponseDto<List<VacancyDto>> getAll() {
        return new ApiResponseDto<>(vacancyService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<VacancyDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(vacancyService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@ModelAttribute CreateVacancyRequest request,
                                 @RequestParam(name = "file") MultipartFile file) {
        vacancyService.add(request, file);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<VacancyDto> update(@ModelAttribute VacancyDto vacancyDto,
                                             @RequestParam(name = "file") MultipartFile file) {
        return new ApiResponseDto<>(vacancyService.update(vacancyDto, file));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        vacancyService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}