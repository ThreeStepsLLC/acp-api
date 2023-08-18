package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.ProjectImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectImageRepository extends JpaRepository<ProjectImage, String> {
}