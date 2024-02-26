package com.mentors.HiringProcess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.TalentPool;

public interface TalentPoolRepository extends JpaRepository<TalentPool, Long>{

	TalentPool findByName(String name);

}
