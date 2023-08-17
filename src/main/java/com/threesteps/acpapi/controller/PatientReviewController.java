package com.threesteps.acpapi.controller;

import com.threesteps.acpapi.dto.ApiResponseDto;
import com.threesteps.acpapi.dto.PatientReviewDto;
import com.threesteps.acpapi.dto.PatientReviewLangedDto;
import com.threesteps.acpapi.service.PatientReviewService;
import com.threesteps.acpapi.service.helper.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient-reviews")
public class PatientReviewController {

    private final PatientReviewService patientReviewService;
    private final LanguageService languageService;

    public PatientReviewController(PatientReviewService patientReviewService, LanguageService languageService) {
        this.patientReviewService = patientReviewService;
        this.languageService = languageService;
    }

    @GetMapping
    public ApiResponseDto<List<PatientReviewDto>> getAll() {
        return new ApiResponseDto<>(patientReviewService.getAll());
    }

    @GetMapping("/last-langed")
    public ApiResponseDto<List<PatientReviewLangedDto>> getLastLanged() {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(patientReviewService.getLastLanged(language));
    }

    @GetMapping("/{id}")
    public ApiResponseDto<PatientReviewLangedDto> getById(@PathVariable String id) {
        var language = languageService.getLanguage();
        return new ApiResponseDto<>(patientReviewService.getByIdLanged(id, language));
    }

}