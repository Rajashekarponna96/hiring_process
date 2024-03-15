package com.mentors.HiringProcess.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.UserAccout;

public interface UserAccoutRepository extends JpaRepository<UserAccout, Long>{

	//UserAccout findByUserName(String userName);
	
	Optional<UserAccout> findByUserName(String userName);

	Optional<UserAccout> findByPassword(String password);

	UserAccout findByUserNameAndPassword(String userName, String password);

	
	
}
