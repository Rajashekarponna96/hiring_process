package com.mentors.HiringProcess.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Job;
import com.mentors.HiringProcess.model.TalentPool;

public interface TalentPoolRepository extends JpaRepository<TalentPool, Long>{

	TalentPool findByName(String name);
	Page<TalentPool> findAll(Specification<TalentPool> spec, Pageable pageable);

}
