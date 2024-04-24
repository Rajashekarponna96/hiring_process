package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.model.Permission;

public interface PermissionService {

	List<Permission> findPermissionsByRoleId(Long roleId);
}
