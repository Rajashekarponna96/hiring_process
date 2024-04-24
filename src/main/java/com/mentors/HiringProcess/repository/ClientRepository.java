package com.mentors.HiringProcess.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	Page<Client> findAll(Specification<Client> spec, Pageable pageable); // Custom method for fetching entities based on specifications and pageable



}
