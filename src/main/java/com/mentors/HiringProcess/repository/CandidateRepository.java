package com.mentors.HiringProcess.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long>{

	Optional<Candidate> findByEmail(String email);

	Optional<Candidate> findByMobile(String mobile);

}
