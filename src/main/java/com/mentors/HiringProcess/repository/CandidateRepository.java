package com.mentors.HiringProcess.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mentors.HiringProcess.dto.VendorDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.Vendor;

public interface CandidateRepository extends JpaRepository<Candidate,Long>{

	Optional<Candidate> findByEmail(String email);

	Optional<Candidate> findByMobile(String mobile);
	
	@Query("SELECT c FROM Candidate c WHERE " +
	           "(:firstName is null or c.firstName = :firstName) " +
	           "and (:lastName is null or c.lastName = :lastName) " +
	           "and (:email is null or c.email = :email)")
	List<Candidate> findByCriteria(String firstName, String lastName, String email);
	
	
	Page<Candidate> findAll(Specification<Candidate> spec, Pageable pageable); // Custom method for fetching entities based on specifications and pageable
	
	
	//List<Candidate> findByVendor(Vendor vendor);
	  List<Candidate> findByVendor(VendorDto vendor);
	  
	  List<Candidate> findByVendor(Vendor vendor);


}
