package com.threesteps.acpapi.controller.admin;


import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.PatientReviewDto;
import com.threesteps.acpapi.dto.CreatePatientReviewRequest;
import com.threesteps.acpapi.service.PatientReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin-patient-reviews")
public class AdminPatientReviewController {

    private final PatientReviewService patientReviewService;

    public AdminPatientReviewController(PatientReviewService patientReviewService) {
        this.patientReviewService = patientReviewService;
    }

    @GetMapping
    public ApiResponseDto<List<PatientReviewDto>> getAll() {
        return new ApiResponseDto<>(patientReviewService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<PatientReviewDto> getById(@PathVariable String id) {
        return new ApiResponseDto<>(patientReviewService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApiResponseDto<?> add(@ModelAttribute CreatePatientReviewRequest request,
                                 @RequestParam(name = "file") MultipartFile file) {
        patientReviewService.add(request, file);
        return new ApiResponseDto<>(null);
    }

    @PutMapping
    public ApiResponseDto<PatientReviewDto> update(@ModelAttribute PatientReviewDto patientReviewDto,
                                          @RequestParam(name = "file") MultipartFile file) {
        return new ApiResponseDto<>(patientReviewService.update(patientReviewDto, file));
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteById(@PathVariable String id) {
        patientReviewService.deleteById(id);
        return new ApiResponseDto<>(null);
    }

}
