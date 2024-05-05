package com.mentors.HiringProcess.specification;

import org.springframework.data.jpa.domain.Specification;

import com.mentors.HiringProcess.model.EmailTemplate;

import jakarta.persistence.criteria.Predicate;

public class EmailTemplateSpecifications {
	
	public static Specification<EmailTemplate> hasFields(String code) {
        return (root, query, builder) -> {
            String likeSearchTerm = "%" + code + "%";
            Predicate predicateSubject= builder.like(root.get("subject"), likeSearchTerm);
            Predicate predicateBody = builder.like(root.get("body"), likeSearchTerm);
            Predicate predicateTitle = builder.like(root.get("title"), likeSearchTerm);
           
            return builder.or(predicateSubject, predicateBody,predicateTitle);
        };
    }


}
