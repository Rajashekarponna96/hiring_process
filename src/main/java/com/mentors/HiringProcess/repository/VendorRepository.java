package com.mentors.HiringProcess.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

	Page<Vendor> findAll(Specification<Vendor> spec, Pageable pageable);

	Vendor findByUserAccoutId(Long userAccountId);
	
	Page<Vendor> findById(Long id,Pageable pageable);
	
	Page<Candidate> findByUserAccoutId(Long userAccountId, Pageable pageable);
	
	List<Vendor> findAll();

}
