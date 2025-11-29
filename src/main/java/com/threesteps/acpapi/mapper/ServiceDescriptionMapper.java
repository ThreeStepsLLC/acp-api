package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.ServiceDescriptionDto;
import com.threesteps.acpapi.model.ServiceDescription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceDescriptionMapper {

    ServiceDescriptionDto toDto(ServiceDescription serviceDescription);

    ServiceDescription toEntity(ServiceDescriptionDto serviceDescriptionDto);

}
