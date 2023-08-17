package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPermissionRepository extends JpaRepository<UserPermission, String> {

    List<UserPermission> findAllByUserId(String id);
    Optional<UserPermission> findByPermissionIdAndUserId(String permissionId, String userId);
    void deleteByUserId(String userId);
}