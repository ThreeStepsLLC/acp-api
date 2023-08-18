package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDetailRepository extends JpaRepository<ProjectDetail, String> {
}