package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, String> {
}