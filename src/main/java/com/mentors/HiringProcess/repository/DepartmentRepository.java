package com.mentors.HiringProcess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
