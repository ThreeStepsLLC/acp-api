package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.ServiceDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDescriptionRepository extends JpaRepository<ServiceDescription, String> {
}
