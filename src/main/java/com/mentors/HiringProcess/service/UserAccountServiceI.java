package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.LoginDto;
import com.mentors.HiringProcess.dto.UserAccoutDto;
import com.mentors.HiringProcess.model.UserAccout;

public interface UserAccountServiceI {

	void addUser(UserAccoutDto userAccoutDto);

	List<UserAccoutDto> allUsers();

	void updateUserAccount(Long id, UserAccoutDto userAccoutDto);

	void deleteUserAccount(Long id);

	UserAccout doLogin(LoginDto loginDto);

	

}
