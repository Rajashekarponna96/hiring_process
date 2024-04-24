package com.mentors.HiringProcess.specification;

import org.springframework.data.jpa.domain.Specification;

import com.mentors.HiringProcess.model.Candidate;


import jakarta.persistence.criteria.Predicate;

public class CandidateSpecifications {
	public static Specification<Candidate> hasFields(String code) {
        return (root, query, builder) -> {
            String likeSearchTerm = "%" + code + "%";
            Predicate predicateFirstName = builder.like(root.get("firstName"), likeSearchTerm);
            Predicate predicateLastName = builder.like(root.get("lastName"), likeSearchTerm);
            Predicate predicateEmail = builder.like(root.get("email"), likeSearchTerm);
            Predicate predicateMobile = builder.like(root.get("mobile"), likeSearchTerm);
            Predicate predicateAlterMobile = builder.like(root.get("alterMobile"),likeSearchTerm);
           // Predicate predicateSource = builder.like(root.get("source"),likeSearchTerm);
            //Predicate predicateStage = builder.like(root.get("stage"),likeSearchTerm);
           // Predicate predicateCurrent = builder.like(root.get("current"),likeSearchTerm);
            Predicate predicateAvialToJoin = builder.like(root.get("avialToJoin"),likeSearchTerm);
            //Predicate predicatePreferred = builder.like(root.get("preferred"),likeSearchTerm);
            //Predicate predicateCurrentSalary = builder.like(root.get("currentSalary"),likeSearchTerm);
            //Predicate predicateExpectedSalary = builder.like(root.get("expectedSalary"),likeSearchTerm);
//            Predicate predicateCurrency = builder.like(root.get("currency"),likeSearchTerm);
//            Predicate predicateGender = builder.like(root.get("gender"),likeSearchTerm);
//            Predicate predicateDateOfBirth = builder.like(root.get("dateOfBirth"),likeSearchTerm);
//            Predicate predicateSkills = builder.like(root.get("skills"),likeSearchTerm);
//            Predicate predicateExperiences = builder.like(root.get("experiences"),likeSearchTerm);
//            Predicate predicateEducations = builder.like(root.get("educations"),likeSearchTerm);
//            Predicate predicateTalentPool = builder.like(root.get("talentPool"),likeSearchTerm);
//            Predicate predicateJob = builder.like(root.get("job"),likeSearchTerm);
            
            
            
            
            
//            return builder.or(predicateFirstName, predicateLastName, predicateEmail, predicateMobile,predicateAlterMobile,predicateSource,predicateStage,predicateCurrent,
//            		predicateAvialToJoin,predicatePreferred,predicateCurrentSalary,predicateExpectedSalary,predicateCurrency,predicateGender,predicateDateOfBirth,predicateSkills,
//            		predicateExperiences,predicateEducations,predicateEducations,predicateTalentPool,predicateJob);
            
            return builder.or(predicateFirstName, predicateLastName, predicateEmail, predicateMobile,predicateAlterMobile, predicateAvialToJoin);

        };
    }

}
