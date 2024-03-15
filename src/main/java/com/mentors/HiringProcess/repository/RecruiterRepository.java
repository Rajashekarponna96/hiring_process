package com.mentors.HiringProcess.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long>{

	Optional<Recruiter> findByEmail(String email);

	Optional<Recruiter> findByMobile(String mobile);

}
