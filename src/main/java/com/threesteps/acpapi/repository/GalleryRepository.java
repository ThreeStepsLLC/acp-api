package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.Gallery;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery, String> {
    List<Gallery> findAllByOrderByCreateDateDesc(PageRequest pageRequest);
    List<Gallery> findAllByOrderByCreateDateDesc();
}