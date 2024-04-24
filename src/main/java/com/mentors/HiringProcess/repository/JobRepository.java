package com.mentors.HiringProcess.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


import com.mentors.HiringProcess.model.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
	
	Page<Job> findAll(Specification<Job> spec, Pageable pageable); 



}
