package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.RoleDto;

public interface RoleServiceI {

	void addRole(RoleDto roleDto);

	List<RoleDto> getAllRoles();

	void updateRole(Long id, RoleDto roleDto);

	void deleteRole(Long id);

}
