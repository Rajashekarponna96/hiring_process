package com.mentors.HiringProcess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
