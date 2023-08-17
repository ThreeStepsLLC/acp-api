package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.CreateUserRequest;
import com.threesteps.acpapi.dto.TokenResponseDto;
import com.threesteps.acpapi.exception.UserAlreadyExistsException;
import com.threesteps.acpapi.service.helper.TokenService;
import com.threesteps.acpapi.dto.LoginDto;
import com.threesteps.acpapi.dto.RegisterRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final BCryptPasswordEncoder encoder;
    private final UserService userService;
    private final TokenService tokenService;
    private final UserPermissionService userPermissionService;

    public AuthService(BCryptPasswordEncoder encoder,
                       UserService userService,
                       TokenService tokenService,
                       UserPermissionService userPermissionService) {
        this.encoder = encoder;
        this.userService = userService;
        this.tokenService = tokenService;
        this.userPermissionService = userPermissionService;
    }

    public TokenResponseDto register(RegisterRequest request) {
        var userInDb = userService.findByUsernameWithoutException(request.getUsername());
        if (userInDb != null)
            throw new UserAlreadyExistsException("Username artıq istifadə olunub");

        var createRequest = new CreateUserRequest(request.getFirstName(),
                request.getLastName(),
                request.getUsername(),
                encoder.encode(request.getPassword()),
                true);

        var user = userService.add(createRequest);
        var token = tokenService.generateToken(user.getUsername());
        var permissionlist = userPermissionService.getPermissionsByUserId(user.getId());

        return new TokenResponseDto(
                user.getFirstName(),
                user.getLastName(),
                token,
                permissionlist
        );
    }

    public TokenResponseDto login(LoginDto loginDto) {
        var user = userService.findByUsername(loginDto.getUsername());

        if (!encoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Password error!");
        }

        var token = tokenService.generateToken(user.getUsername());
        var permissionlist = userPermissionService.getPermissionsByUserId(user.getId());
        return new TokenResponseDto(
                user.getFirstName(),
                user.getLastName(),
                token,
                permissionlist
        );
    }

}
