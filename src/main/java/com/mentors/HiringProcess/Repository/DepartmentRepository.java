package com.mentors.HiringProcess.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
