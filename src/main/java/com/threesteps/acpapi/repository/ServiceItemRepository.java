package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.ServiceItem;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceItemRepository extends JpaRepository<ServiceItem, String> {
    List<ServiceItem> findAllByOrderByOrderNumberAsc();
    List<ServiceItem> findAllByOrderByOrderNumberAsc(PageRequest pageRequest);
    List<ServiceItem> findAllByOrderByCreateDateDesc();
}
