package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.UserPermissionDto;
import com.threesteps.acpapi.dto.CreateUserPermissionRequest;
import com.threesteps.acpapi.model.Permission;
import com.threesteps.acpapi.model.User;
import com.threesteps.acpapi.model.UserPermission;
import org.springframework.stereotype.Component;

@Component
public class UserPermissionMapper {

    private final UserMapper userMapper;
    private final PermissionMapper permissionMapper;

    public UserPermissionMapper(UserMapper userMapper, PermissionMapper permissionMapper) {
        this.userMapper = userMapper;
        this.permissionMapper = permissionMapper;
    }

    public UserPermissionDto toDTO(UserPermission from) {
        if (from == null) return null;
        return new UserPermissionDto(from.getId(),
                userMapper.toDTO(from.getUser()),
                permissionMapper.toDTO(from.getPermission()));
    }

    public UserPermission toDBO(CreateUserPermissionRequest from) {
        if (from == null) return null;
        return new UserPermission(null, new User(from.getUser().getId()),
                new Permission(from.getPermission().getId()));
    }

}