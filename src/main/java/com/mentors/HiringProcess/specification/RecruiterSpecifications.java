package com.mentors.HiringProcess.specification;


import org.springframework.data.jpa.domain.Specification;
import com.mentors.HiringProcess.model.Recruiter;

import jakarta.persistence.criteria.Predicate;

public class RecruiterSpecifications {
	
	 public static Specification<Recruiter> hasFields(String code) {
	        return (root, query, builder) -> {
	            String likeSearchTerm = "%" + code + "%";
	            Predicate predicateFirstName = builder.like(root.get("firstName"), likeSearchTerm);
	            Predicate predicateLastName = builder.like(root.get("lastName"), likeSearchTerm);
	            Predicate predicateEmail = builder.like(root.get("email"), likeSearchTerm);
	            Predicate predicateMobile = builder.like(root.get("mobile"), likeSearchTerm);
	            return builder.or(predicateFirstName, predicateLastName, predicateEmail, predicateMobile);
	        };
	    }
}
