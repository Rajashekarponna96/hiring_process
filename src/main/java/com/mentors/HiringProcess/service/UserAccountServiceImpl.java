package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mentors.HiringProcess.builder.UserAccoutBuilder;
import com.mentors.HiringProcess.common.CommonException;
import com.mentors.HiringProcess.common.CommonExceptionMessage;
import com.mentors.HiringProcess.dto.LoginDto;
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
		if(userAccoutRepository.findByUserName(userAccoutDto.getUserName()).isPresent()) {
			throw new RuntimeException("UserName is Already Exit");
		}
		if(userAccoutRepository.findByPassword(userAccoutDto.getPassword()).isPresent()) {
			throw new RuntimeException("Password is Already Exit");
		}
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


	@Override
	public UserAccout doLogin(LoginDto loginDto) {
		UserAccout userAccount=userAccoutRepository.findByUserNameAndPassword(loginDto.getUserName(), loginDto.getPassword());
		if(userAccount!=null) {
			
		}
		else {
			throw CommonException.CreateException(CommonExceptionMessage.INCORRECT_UserNameAndPassword);
		}
		return userAccount;
	}

}
