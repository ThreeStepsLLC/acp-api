package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.CreateSeparateLicenseRequest;
import com.threesteps.acpapi.dto.SeparateLicenseDto;
import com.threesteps.acpapi.model.SeparateLicense;
import org.springframework.stereotype.Component;

@Component
public class SeparateLicenseMapper {

    public SeparateLicenseDto toDTO(SeparateLicense from) {
        if (from == null) return null;

        return new SeparateLicenseDto(from.getId(), from.getImageUrl());
    }

    public SeparateLicense toDBO(CreateSeparateLicenseRequest from) {
        if (from == null) return null;

        return new SeparateLicense(null, from.getImageUrl());
    }

    public SeparateLicense toDBO(SeparateLicenseDto from) {
        if (from == null) return null;

        return new SeparateLicense(from.getId(), from.getImageUrl());
    }

}