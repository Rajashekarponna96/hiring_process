package com.mentors.HiringProcess.specification;

import org.springframework.data.jpa.domain.Specification;

import com.mentors.HiringProcess.model.Client;

import jakarta.persistence.criteria.Predicate;

public class ClientSprecifications {
	
	 public static Specification<Client> hasFields(String code) {
	        return (root, query, builder) -> {
	            String likeSearchTerm = "%" + code + "%";
	            Predicate predicateCompanyName = builder.like(root.get("companyName"), likeSearchTerm);
	            Predicate predicateLocation = builder.like(root.get("location"), likeSearchTerm);
	           
	            return builder.or(predicateCompanyName, predicateLocation);
	        };
	    }

}
