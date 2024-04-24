package com.mentors.HiringProcess.specification;

import org.springframework.data.jpa.domain.Specification;

import com.mentors.HiringProcess.model.Job;

import jakarta.persistence.criteria.Predicate;

public class JobSpecifications {
	
	public static Specification<Job> hasFields(String code) {
        return (root, query, builder) -> {
            String likeSearchTerm = "%" + code + "%";
            Predicate predicateTitle = builder.like(root.get("title"), likeSearchTerm);
            Predicate predicateDescription = builder.like(root.get("description"), likeSearchTerm);
            Predicate predicateLocations = builder.like(root.get("locations"), likeSearchTerm);
            Predicate predicateExpectedNoticePeriod = builder.like(root.get("expectedNoticePeriod"), likeSearchTerm);
            Predicate predicatePrimarySkills = builder.like(root.get("primarySkills"), likeSearchTerm);
            Predicate predicateSecondarySkills = builder.like(root.get("secondarySkills"), likeSearchTerm);
            Predicate predicateGoodToHave= builder.like(root.get("goodToHave"), likeSearchTerm);
            
           
            return builder.or( predicateTitle, predicateDescription,predicateLocations, predicateExpectedNoticePeriod,predicatePrimarySkills,
            		predicateSecondarySkills,predicateGoodToHave);
        };
    }

}
