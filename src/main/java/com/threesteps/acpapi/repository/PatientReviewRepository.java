package com.threesteps.acpapi.repository;

import com.threesteps.acpapi.model.PatientReview;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientReviewRepository extends JpaRepository<PatientReview, String> {

    List<PatientReview> findAllByOrderByCreateDateDesc();

}