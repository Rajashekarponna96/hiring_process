package com.mentors.HiringProcess.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

}
