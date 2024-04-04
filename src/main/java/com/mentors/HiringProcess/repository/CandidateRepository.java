package com.mentors.HiringProcess.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long>{

	Optional<Candidate> findByEmail(String email);

	Optional<Candidate> findByMobile(String mobile);
	
	@Query("SELECT c FROM Candidate c WHERE " +
	           "(:firstName is null or c.firstName = :firstName) " +
	           "and (:lastName is null or c.lastName = :lastName) " +
	           "and (:email is null or c.email = :email)")
	List<Candidate> findByCriteria(String firstName, String lastName, String email);



}
