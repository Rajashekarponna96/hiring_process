package com.mentors.HiringProcess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mentors.HiringProcess.model.HiringFlowActivity;
import com.mentors.HiringProcess.model.HiringFlowType;

public interface HiringFlowActivityRepository extends JpaRepository<HiringFlowActivity, Long>{
	 List<HiringFlowActivity> findByCandidateId(Long candidateId);
	 
	 @Query("SELECT c FROM HiringFlowActivity c WHERE c.hiringFlowType = hiringFlowType")
	 List<HiringFlowActivity> findByHiringFlowType( HiringFlowType  hiringFlowType);

}
