package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.ServiceDescriptionDto;
import com.threesteps.acpapi.model.ServiceDescription;
import org.springframework.stereotype.Component;

@Component
public class ServiceDescriptionMapper {

    public ServiceDescriptionDto toDto(ServiceDescription from) {
        if (from == null) return null;

        return new ServiceDescriptionDto(
                from.getId(),
                from.getDescriptionAz(),
                from.getDescriptionEn(),
                from.getDescriptionRu()
        );
    }

    public ServiceDescription toEntity(ServiceDescriptionDto from) {
        if (from == null) return null;

        return new ServiceDescription(
                from.getId(),
                from.getDescriptionAz(),
                from.getDescriptionEn(),
                from.getDescriptionRu()
        );
    }

}
