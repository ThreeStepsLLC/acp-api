package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, String> {

    Optional<Permission> findByTitle(String title);

}