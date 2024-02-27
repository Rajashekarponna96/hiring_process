package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.RoleDto;
import com.mentors.HiringProcess.service.RoleServiceI;



@RestController
@RequestMapping(value = "/role")
@CrossOrigin
public class RoleController {

	@Autowired
	private RoleServiceI roleServiceI;
	
	@PostMapping(value = "/add")
	public void addRole(@RequestBody RoleDto roleDto) {
		System.out.println("rolename is"+roleDto.getName());
		roleServiceI.addRole(roleDto);
	}
	
	@GetMapping(value = "/all")
	public List<RoleDto> getAllRoles(){
		return roleServiceI.getAllRoles();
	}
	
	@PutMapping(value = "/{id}")
	public void updateRole(@PathVariable Long id, @RequestBody RoleDto roleDto) {
		roleServiceI.updateRole(id, roleDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteRole(@PathVariable Long id) {
		roleServiceI.deleteRole(id);
	}
	
	
}
