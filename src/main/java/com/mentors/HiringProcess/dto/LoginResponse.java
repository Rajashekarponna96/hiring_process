package com.mentors.HiringProcess.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.mentors.HiringProcess.model.UserAccout;

public class LoginResponse {
	
	  private final UserAccout userAccount;
      private final String role;
      private final List<String> permissions;

      public LoginResponse(UserAccout userAccount) {
          this.userAccount = userAccount;
          // Retrieve role and permissions from the user account object
          this.role = userAccount.getRole().getName();
          this.permissions = userAccount.getRole().getPermissions().stream()
                  .map(permission -> permission.getName())
                  .collect(Collectors.toList());
      }

}
