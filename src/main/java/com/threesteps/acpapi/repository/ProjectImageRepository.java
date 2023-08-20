package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.ProjectImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectImageRepository extends JpaRepository<ProjectImage, String> {
    List<ProjectImage> findAllByProjectId(String projectId);

}