package com.mentors.HiringProcess.specification;

import org.springframework.data.jpa.domain.Specification;
import com.mentors.HiringProcess.model.Recruiter;

public class RecruiterSpecifications {

	public static Specification<Recruiter> hasFirstName(String firstName) {
		return (root, query, builder) -> builder.like(root.get("firstName"), "%" + firstName + "%");
	}

	public static Specification<Recruiter> hasLastName(String lastName) {
		return (root, query, builder) -> builder.like(root.get("lastName"), "%" + lastName + "%");
	}

	// Add more specifications as needed
}
