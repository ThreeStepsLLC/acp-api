package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.UserDto;
import com.threesteps.acpapi.dto.CreateUserRequest;
import com.threesteps.acpapi.dto.UserPasswordDto;
import com.threesteps.acpapi.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDTO(User from) {
        if (from == null) return null;
        return new UserDto(from.getId(),
                from.getUsername(),
                from.getFirstName(),
                from.getLastName(),
                from.getStatus());
    }

    public User toDBO(CreateUserRequest from) {
        if (from == null) return null;
        return new User(null,
                from.getUsername(),
                from.getFirstName(),
                from.getLastName(),
                from.getPassword(),
                from.getStatus());
    }

    public User toDBO(UserPasswordDto from) {
        if (from == null) return null;
        return new User(from.getId(),
                from.getUsername(),
                from.getFirstName(),
                from.getLastName(),
                from.getPassword(),
                from.getStatus());
    }

}