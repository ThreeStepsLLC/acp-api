package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, String> {
}