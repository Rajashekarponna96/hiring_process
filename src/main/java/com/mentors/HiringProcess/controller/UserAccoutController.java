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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.LoginDto;
import com.mentors.HiringProcess.dto.UserAccoutDto;
import com.mentors.HiringProcess.model.UserAccout;
import com.mentors.HiringProcess.service.UserAccountServiceI;

@RestController
@RequestMapping(value = "/userAccount")
@CrossOrigin
public class UserAccoutController {

	@Autowired
	private UserAccountServiceI userAccountServiceI;

	@PostMapping(value = "/add")
	public void addUserAccount(@RequestBody UserAccoutDto userAccoutDto) {
		userAccoutDto.validateRequiredAttibutes(userAccoutDto);
		userAccountServiceI.addUser(userAccoutDto);
	}

	@GetMapping(value = "/all")
	public List<UserAccoutDto> allUsers() {
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

	@RequestMapping(value = "/loginone", method = RequestMethod.POST)
	public UserAccout doLogin(@RequestBody LoginDto loginDto) {
		loginDto.validateLoginRequired(loginDto);
		return userAccountServiceI.doLogin(loginDto);
	}

	@PostMapping("/login")
	public UserAccoutDto login(@RequestBody LoginDto loginDto) {
		return userAccountServiceI.login(loginDto);
	}

}
