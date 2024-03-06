package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mentors.HiringProcess.dto.DepartmentDto;
import com.mentors.HiringProcess.service.DepartmentServicel;

@RestController
@RequestMapping(value = "/department")
@CrossOrigin
public class DepartmentController {
	
	@Autowired
	private DepartmentServicel departmentServicel;
	
	@GetMapping(value = "/all")
	public List<DepartmentDto> getAll() {
		return departmentServicel.getAll();
	}
	

}
