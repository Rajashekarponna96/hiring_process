package com.mentors.HiringProcess.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mentors.HiringProcess.model.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long>{

	Optional<Recruiter> findByEmail(String email);

	Optional<Recruiter> findByMobile(String mobile);

	List<Recruiter> findByFirstName(String firstName);
    
	@Query(value = "SELECT u FROM Recruiter u WHERE u.firstName LIKE %:code% OR u.lastName LIKE %:code% OR u.email LIKE %:code% OR u.mobile LIKE %:code%",
		       countQuery = "SELECT COUNT(u) FROM Recruiter u WHERE u.firstName LIKE %:code% OR u.lastName LIKE %:code% OR u.email LIKE %:code% OR u.mobile LIKE %:code%")
		Page<Recruiter> findUsersByCode(String code, Pageable pageable);

}
