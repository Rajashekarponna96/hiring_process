package com.mentors.HiringProcess.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.PermissionDto;
import com.mentors.HiringProcess.dto.RoleDto;
import com.mentors.HiringProcess.model.Permission;
import com.mentors.HiringProcess.model.Role;

@Component
public class RoleBuilder {

	public Role toModel(RoleDto roleDto) {

		Role role = new Role();
		role.setId(roleDto.getId());
		role.setName(roleDto.getName());
		role.setDescription(roleDto.getDescription());
		
		return role;
	}

	
	public RoleDto toDto(Role role) {
		RoleDto roledto = new RoleDto();
		roledto.setName(role.getName());
		roledto.setDescription(role.getDescription());
		
		List<PermissionDto> permissionDtos = new ArrayList<>();
	    for (Permission permission : role.getPermissions()) {
	    	PermissionDto permissionDto = new PermissionDto();
	    	permissionDto.setId(permission.getId());
	    	permissionDtos.add(permissionDto);
	    }
	    roledto.setPermissions(permissionDtos);
		
		return roledto;
}
}
