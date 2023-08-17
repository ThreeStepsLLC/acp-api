package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.UsefulInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsefulInfoRepository extends JpaRepository<UsefulInfo, String> {

    List<UsefulInfo> findAllByOrderByCreateDateDesc();

}