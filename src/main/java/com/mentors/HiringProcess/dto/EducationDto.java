package com.mentors.HiringProcess.dto;

import java.time.LocalDate;

public class EducationDto {
	
    private Long id;
	
	private String course;
	
	private String branch;
	
	private LocalDate startOfCourse;
	
	private LocalDate endOfCourse;
	
	private String college;
	
	private String university;
	
	private String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public LocalDate getStartOfCourse() {
		return startOfCourse;
	}

	public void setStartOfCourse(LocalDate startOfCourse) {
		this.startOfCourse = startOfCourse;
	}

	public LocalDate getEndOfCourse() {
		return endOfCourse;
	}

	public void setEndOfCourse(LocalDate endOfCourse) {
		this.endOfCourse = endOfCourse;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}
	
	

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
