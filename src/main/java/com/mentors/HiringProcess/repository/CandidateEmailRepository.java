package com.mentors.HiringProcess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.CandidateEmail;

public interface CandidateEmailRepository extends JpaRepository<CandidateEmail, Long>{

}
