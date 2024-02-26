package com.mentors.HiringProcess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long>{

}
