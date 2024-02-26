package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.UserAccoutDto;

public interface UserAccountServiceI {

	void addUser(UserAccoutDto userAccoutDto);

	List<UserAccoutDto> allUsers();

	void updateUserAccount(Long id, UserAccoutDto userAccoutDto);

	void deleteUserAccount(Long id);

}
