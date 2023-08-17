package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.PartnerDto;
import com.threesteps.acpapi.dto.CreatePartnerRequest;
import com.threesteps.acpapi.model.Partner;
import org.springframework.stereotype.Component;

@Component
public class PartnerMapper {

    public PartnerDto toDTO(Partner from) {
        if (from == null) return null;

        return new PartnerDto(from.getId(),
                from.getTitle(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public Partner toDBO(CreatePartnerRequest from) {
        if (from == null) return null;

        return new Partner(null,
                from.getTitle(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public Partner toDBO(PartnerDto from) {
        if (from == null) return null;

        return new Partner(from.getId(),
                from.getTitle(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

}