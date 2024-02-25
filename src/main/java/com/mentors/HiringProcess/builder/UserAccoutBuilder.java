package com.mentors.HiringProcess.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.UserAccoutDto;
import com.mentors.HiringProcess.model.UserAccout;

@Component
public class UserAccoutBuilder {

	@Autowired
	private RoleBuilder roleBuilder;

	

	public UserAccout toModel(UserAccoutDto userAccoutDto) {

		UserAccout userAccout = new UserAccout();
		userAccout.setId(userAccoutDto.getId());
		userAccout.setUserName(userAccoutDto.getUserName());
		userAccout.setPassword(userAccoutDto.getPassword());
		userAccout.setActive(userAccoutDto.isActive());
		userAccout.setRole(roleBuilder.toModel(userAccoutDto.getRole()));

		return userAccout;
	}

	public UserAccoutDto toDto(UserAccout userAccout) {
		UserAccoutDto userAccoutdto = new UserAccoutDto();
		userAccoutdto.setUserName(userAccout.getUserName());
		userAccoutdto.setPassword(userAccout.getPassword());
		userAccoutdto.setActive(userAccout.isActive());
		userAccoutdto.setRole(roleBuilder.toDto(userAccout.getRole()));
		return userAccoutdto;
	}

}
