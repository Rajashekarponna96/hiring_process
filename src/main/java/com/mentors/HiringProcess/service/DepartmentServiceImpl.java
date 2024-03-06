package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.DepartmentBuilder;
import com.mentors.HiringProcess.dto.DepartmentDto;
import com.mentors.HiringProcess.model.Department;
import com.mentors.HiringProcess.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentServicel{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DepartmentBuilder departmentBuilder;

	@Override
	public List<DepartmentDto> getAll() {
		List<DepartmentDto> departmentDtos = new ArrayList<>();
		List<Department> departments = departmentRepository.findAll();
		if (departments != null) {
			departments.forEach(department -> {
				departmentDtos.add(departmentBuilder.toDto(department));
			});
		}
		return departmentDtos;
	}

}
