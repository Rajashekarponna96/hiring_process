package com.mentors.HiringProcess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.HiringFlowActivity;

public interface HiringFlowActivityRepository extends JpaRepository<HiringFlowActivity, Long>{
	 List<HiringFlowActivity> findByCandidateId(Long candidateId);

}
