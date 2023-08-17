package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.Constant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstantRepository extends JpaRepository<Constant, String> {
}