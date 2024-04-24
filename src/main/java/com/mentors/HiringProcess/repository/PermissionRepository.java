package com.mentors.HiringProcess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

	List<Permission> findByRoleId(Long roleId);
}
