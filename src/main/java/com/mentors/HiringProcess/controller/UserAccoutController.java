	package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.RoleDto;
import com.mentors.HiringProcess.dto.UserAccoutDto;
import com.mentors.HiringProcess.model.UserAccout;
import com.mentors.HiringProcess.service.UserAccountServiceI;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/userAccount")
@CrossOrigin
public class UserAccoutController {
	
	@Autowired
	private UserAccountServiceI userAccountServiceI;
	
	@PostMapping(value = "/add")
	public void addUserAccount(@RequestBody UserAccoutDto userAccoutDto) {
		userAccountServiceI.addUser(userAccoutDto);
	}
	
	@GetMapping(value = "/all")
	public List<UserAccoutDto> allUsers(){
		return userAccountServiceI.allUsers();
	}
	
	@PutMapping(value = "/{id}")
	public void updateUserAccount(@PathVariable Long id, @RequestBody UserAccoutDto userAccoutDto) {
		userAccountServiceI.updateUserAccount(id, userAccoutDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteUserAccount(@PathVariable Long id) {
		userAccountServiceI.deleteUserAccount(id);
	}


}
