package com.threesteps.acpapi.startup;

import com.threesteps.acpapi.dto.CreateUserRequest;
import com.threesteps.acpapi.model.Permission;
import com.threesteps.acpapi.model.User;
import com.threesteps.acpapi.model.UserPermission;
import com.threesteps.acpapi.model.enums.Permissions;
import com.threesteps.acpapi.service.PermissionService;
import com.threesteps.acpapi.service.UserPermissionService;
import com.threesteps.acpapi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserPermissionStartup implements CommandLineRunner {

    private final PermissionService permissionService;
    private final UserService userService;
    private final UserPermissionService userPermissionService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserPermissionStartup(PermissionService permissionService,
                                 UserService userService,
                                 UserPermissionService userPermissionService,
                                 BCryptPasswordEncoder passwordEncoder) {
        this.permissionService = permissionService;
        this.userService = userService;
        this.userPermissionService = userPermissionService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) {
        createRootUser();
        createPermissions();
        createUserPermissionForRoot();
    }

    public void createRootUser() {
        var userInDb = userService.findByUsernameWithoutException("root");
        if (userInDb != null) return;

        var newUser = new CreateUserRequest("root",
                "Admin",
                "Admin",
                passwordEncoder.encode("123456789"),
                true);

        userService.add(newUser);
    }

    public void createPermissions() {
        for (var permission : Permissions.values()) {
            var permissionInDb = permissionService.findByIdOptional(permission.getTitle());
            if (permissionInDb.isPresent()) {
                permissionService.update(new Permission(permission.getId(), permission.getTitle()));
            } else {
                permissionService.add(new Permission(permission.getId(), permission.getTitle()));
            }
        }
    }

    public void createUserPermissionForRoot() {
        var rootUser = userService.findByUsername("root");

        for (var permission : Permissions.values()) {
            var userPermission = userPermissionService
                    .findUserPermissionByPermissionIdAndUserId(permission.getId(), rootUser.getId());

            if (userPermission.isPresent()) continue;

            var newUserPermission = new UserPermission(null,
                    new User(rootUser.getId()),
                    new Permission(permission.getId()));

            userPermissionService.add(newUserPermission);
        }
    }
}
