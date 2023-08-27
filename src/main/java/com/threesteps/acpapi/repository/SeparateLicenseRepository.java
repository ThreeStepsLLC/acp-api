package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.SeparateLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeparateLicenseRepository extends JpaRepository<SeparateLicense, String> {
}