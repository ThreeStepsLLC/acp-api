package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.ServiceItemDto;
import com.threesteps.acpapi.dto.CreateServiceItemRequest;
import com.threesteps.acpapi.model.ServiceItem;
import org.springframework.stereotype.Component;

@Component
public class ServiceItemMapper {

    public ServiceItemDto toDTO(ServiceItem from) {
        if (from == null) return null;

        return new ServiceItemDto(
                from.getId(),
                from.getTitleAz(),
                from.getTitleEn(),
                from.getTitleRu(),
                from.getDescriptionAz(),
                from.getDescriptionEn(),
                from.getDescriptionRu(),
                from.getIconUrl(),
                from.getOrderNumber(),
                from.getCreateDate(),
                from.getStatus()
        );
    }

    public ServiceItem toDBO(CreateServiceItemRequest from) {
        if (from == null) return null;

        return new ServiceItem(
                null,
                from.getTitleAz(),
                from.getTitleEn(),
                from.getTitleRu(),
                from.getDescriptionAz(),
                from.getDescriptionEn(),
                from.getDescriptionRu(),
                from.getIconUrl(),
                from.getOrderNumber(),
                from.getCreateDate(),
                from.getStatus()
        );
    }

    public ServiceItem toDBO(ServiceItemDto from) {
        if (from == null) return null;

        return new ServiceItem(
                from.getId(),
                from.getTitleAz(),
                from.getTitleEn(),
                from.getTitleRu(),
                from.getDescriptionAz(),
                from.getDescriptionEn(),
                from.getDescriptionRu(),
                from.getIconUrl(),
                from.getOrderNumber(),
                from.getCreateDate(),
                from.getStatus()
        );
    }

}
