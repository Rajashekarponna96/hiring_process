package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.model.Permission;
import com.mentors.HiringProcess.service.PermissionService;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
	 @Autowired
	    private PermissionService permissionService;

	    @GetMapping("/{roleId}")
	    public ResponseEntity<List<Permission>> getPermissionsByRoleId(@PathVariable Long roleId) {
	        List<Permission> permissions = permissionService.findPermissionsByRoleId(roleId);
	        return ResponseEntity.ok().body(permissions);
	    }
}
