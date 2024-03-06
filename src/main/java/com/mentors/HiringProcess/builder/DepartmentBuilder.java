package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.DepartmentDto;
import com.mentors.HiringProcess.model.Department;
@Component
public class DepartmentBuilder {
	
	public Department toModel(DepartmentDto departmentDto) {

		Department department = new Department();
		department.setId(departmentDto.getId());
		department.setName(departmentDto.getName());
		department.setCode(departmentDto.getCode());		
		return department;
	}

	
	public DepartmentDto toDto(Department department) {
		
		DepartmentDto departmentDto= new DepartmentDto();
		departmentDto.setId(department.getId());
		departmentDto.setName(department.getName());
		departmentDto.setCode(department.getCode());
		return departmentDto;
}

}
