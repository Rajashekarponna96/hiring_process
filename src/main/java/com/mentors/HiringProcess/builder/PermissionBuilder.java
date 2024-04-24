package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.PermissionDto;
import com.mentors.HiringProcess.model.Permission;

@Component
public class PermissionBuilder {

	public Permission toModel(PermissionDto permissionDto) {

		Permission permission = new Permission();
		permission.setId(permissionDto.getId());
		permission.setName(permissionDto.getName());
		permission.setDescription(permissionDto.getDescription());

		return permission;
	}

	public PermissionDto toDto(Permission permission) {
		PermissionDto permissiondto = new PermissionDto();
		permissiondto.setId(permission.getId());
		permissiondto.setName(permission.getName());
		permissiondto.setDescription(permission.getDescription());
		return permissiondto;
	}

}
