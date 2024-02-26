package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.UserAccoutBuilder;
import com.mentors.HiringProcess.dto.UserAccoutDto;
import com.mentors.HiringProcess.model.UserAccout;
import com.mentors.HiringProcess.repository.UserAccoutRepository;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountServiceI {

	@Autowired
	private UserAccoutRepository userAccoutRepository;

	@Autowired
	private UserAccoutBuilder userAccoutBuilder;

	@Override
	public void addUser(UserAccoutDto userAccoutDto) {
		// TODO Auto-generated method stub
		userAccoutRepository.save(userAccoutBuilder.toModel(userAccoutDto));
	}

	@Override
	public List<UserAccoutDto> allUsers() {
		// TODO Auto-generated method stub
		List<UserAccoutDto> list = new ArrayList<>();
		List<UserAccout> userlList = userAccoutRepository.findAll();
		if (userlList != null) {
			userlList.forEach(user -> {
				list.add(userAccoutBuilder.toDto(user));
			});
		}
		return list;
	}

	@Override
	public void updateUserAccount(Long id, UserAccoutDto userAccoutDto) {
		// TODO Auto-generated method stub
		Optional<UserAccout> dbUserAccout = userAccoutRepository.findById(id);
		if (dbUserAccout.isPresent()) {
			userAccoutRepository.save(userAccoutBuilder.toModel(userAccoutDto));
		}
	}

	@Override
	public void deleteUserAccount(Long id) {
		// TODO Auto-generated method stub
		userAccoutRepository.deleteById(id);
	}

}
