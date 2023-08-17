package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {

    List<Project> findAllByOrderByCreateDateDesc();

}