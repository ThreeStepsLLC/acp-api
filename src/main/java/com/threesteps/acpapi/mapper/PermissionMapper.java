package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.PermissionDto;
import com.threesteps.acpapi.model.Permission;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {

    public PermissionDto toDTO(Permission from) {
        if (from == null) return null;
        return new PermissionDto(from.getId(), from.getTitle());
    }

    public Permission toDBO(PermissionDto from) {
        if (from == null) return null;
        return new Permission(from.getId(), from.getTitle());
    }

}