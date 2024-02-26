package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.RoleBuilder;
import com.mentors.HiringProcess.dto.RoleDto;
import com.mentors.HiringProcess.model.Role;
import com.mentors.HiringProcess.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceimpl implements RoleServiceI {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleBuilder roleBuilder;

	@Override
	public void addRole(RoleDto roleDto) {
		// TODO Auto-generated method stub
		roleRepository.save(roleBuilder.toModel(roleDto));
	}

	@Override
	public List<RoleDto> getAllRoles() {
		// TODO Auto-generated method stub
		List<RoleDto> rolesList = new ArrayList<>();
		List<Role> roles = roleRepository.findAll();
		if (roles != null) {
			roles.forEach(role -> {
				rolesList.add(roleBuilder.toDto(role));
			});
		}
		return rolesList;
	}

	@Override
	public void updateRole(Long id, RoleDto roleDto) {
		// TODO Auto-generated method stub
		Optional<Role> dbRole = roleRepository.findById(id);
		if (dbRole.isPresent()) {
			roleRepository.save(roleBuilder.toModel(roleDto));
		}
	}

	@Override
	public void deleteRole(Long id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
	}

}
