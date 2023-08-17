package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, String> {
}