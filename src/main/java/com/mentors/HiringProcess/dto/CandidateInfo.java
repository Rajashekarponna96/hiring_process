package com.mentors.HiringProcess.dto;

import java.util.List;

public class CandidateInfo {
	 private String firstName;
	    private List<String> skills;

	    public CandidateInfo(String firstName, List<String> skills) {
	        this.firstName = firstName;
	        this.skills = skills;
	    }

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public List<String> getSkills() {
			return skills;
		}

		public void setSkills(List<String> skills) {
			this.skills = skills;
		}

}
