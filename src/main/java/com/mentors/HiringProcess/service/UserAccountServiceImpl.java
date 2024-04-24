package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.PermissionBuilder;
import com.mentors.HiringProcess.builder.RoleBuilder;
import com.mentors.HiringProcess.builder.UserAccoutBuilder;
import com.mentors.HiringProcess.common.CommonException;
import com.mentors.HiringProcess.common.CommonExceptionMessage;
import com.mentors.HiringProcess.dto.LoginDto;
import com.mentors.HiringProcess.dto.PermissionDto;
import com.mentors.HiringProcess.dto.RoleDto;
import com.mentors.HiringProcess.dto.UserAccoutDto;
import com.mentors.HiringProcess.model.Permission;
import com.mentors.HiringProcess.model.Role;
import com.mentors.HiringProcess.model.UserAccout;
import com.mentors.HiringProcess.repository.UserAccoutRepository;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountServiceI {

	@Autowired
	private UserAccoutRepository userAccoutRepository;

	@Autowired
	private UserAccoutBuilder userAccoutBuilder;

	@Autowired
	private RoleBuilder roleBuilder;

	@Autowired
	private PermissionBuilder permissionBuilder;

	@Override
	public void addUser(UserAccoutDto userAccoutDto) {
		if (userAccoutRepository.findByUserName(userAccoutDto.getUserName()).isPresent()) {
			throw new RuntimeException("UserName is Already Exit");
		}
		if (userAccoutRepository.findByPassword(userAccoutDto.getPassword()).isPresent()) {
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
		UserAccout userAccount = userAccoutRepository.findByUserNameAndPassword(loginDto.getUserName(),
				loginDto.getPassword());
		if (userAccount != null) {

		} else {
			throw CommonException.CreateException(CommonExceptionMessage.INCORRECT_UserNameAndPassword);
		}
		return userAccount;
	}

	@Override
	public UserAccoutDto login(LoginDto loginDto) {
		// Retrieve user account based on username and password
		UserAccout userAccount = userAccoutRepository.findByUserNameAndPassword(loginDto.getUserName(),
				loginDto.getPassword());

		if (userAccount != null) {
			// Create a UserAccoutDto from the retrieved user account
			UserAccoutDto userAccountDto = new UserAccoutDto();
			userAccountDto = userAccoutBuilder.toDto(userAccount);
			// Convert Role to RoleDto and set it
			RoleDto roleDto = convertToRoleDto(userAccount.getRole());
			userAccountDto.setRole(roleDto);

			return userAccountDto;
		} else {
			// If user account not found or invalid credentials, throw an exception
			throw CommonException.CreateException(CommonExceptionMessage.INCORRECT_UserNameAndPassword);
		}
	}

	private RoleDto convertToRoleDto(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto = roleBuilder.toDto(role);
		// Convert list of permissions to list of PermissionDto
		List<PermissionDto> permissionDtoList = new ArrayList<>();
		for (Permission permission : role.getPermissions()) {
			PermissionDto permissionDto = new PermissionDto();
			permissionDto = permissionBuilder.toDto(permission);
			permissionDtoList.add(permissionDto);
		}

		roleDto.setPermissions(permissionDtoList);

		return roleDto;
	}

}
