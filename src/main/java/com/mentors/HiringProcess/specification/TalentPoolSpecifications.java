package com.mentors.HiringProcess.specification;

import org.springframework.data.jpa.domain.Specification;

import com.mentors.HiringProcess.model.TalentPool;

import jakarta.persistence.criteria.Predicate;

public class TalentPoolSpecifications {
	
	public static Specification<TalentPool> hasFields(String code) {
        return (root, query, builder) -> {
            String likeSearchTerm = "%" + code + "%";
            Predicate predicateName = builder.like(root.get("name"), likeSearchTerm);
            Predicate predicateLocation = builder.like(root.get("description"), likeSearchTerm);
           
            return builder.or(predicateName, predicateLocation);
        };
    }

}
