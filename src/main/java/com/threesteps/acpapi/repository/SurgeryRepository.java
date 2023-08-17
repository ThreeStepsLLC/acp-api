package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurgeryRepository extends JpaRepository<Surgery, String> {

}