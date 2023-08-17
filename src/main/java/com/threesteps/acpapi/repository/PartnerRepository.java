package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.Partner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnerRepository extends JpaRepository<Partner, String> {
    List<Partner> findAllByOrderByCreateDateDesc(PageRequest pageRequest);
    List<Partner> findAllByOrderByCreateDateDesc();
}