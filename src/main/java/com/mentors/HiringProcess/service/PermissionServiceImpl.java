package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentors.HiringProcess.model.Permission;
import com.mentors.HiringProcess.repository.PermissionRepository;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository; // Assuming you have a PermissionRepository interface

	@Override
	public List<Permission> findPermissionsByRoleId(Long roleId) {
		return permissionRepository.findByRoleId(roleId);
	}
}