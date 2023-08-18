package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, String> {
}