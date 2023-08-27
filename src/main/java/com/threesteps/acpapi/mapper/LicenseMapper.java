package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.CreateLicenseRequest;
import com.threesteps.acpapi.dto.LicenseDto;
import com.threesteps.acpapi.model.License;
import org.springframework.stereotype.Component;

@Component
public class LicenseMapper {

    public LicenseDto toDTO(License from) {
        if (from == null) return null;

        return new LicenseDto(from.getId(), from.getImageUrl());
    }

    public License toDBO(CreateLicenseRequest from) {
        if (from == null) return null;

        return new License(null, from.getImageUrl());
    }

    public License toDBO(LicenseDto from) {
        if (from == null) return null;

        return new License(from.getId(), from.getImageUrl());
    }

}