package com.mentors.HiringProcess.specification;

import org.springframework.data.jpa.domain.Specification;

import com.mentors.HiringProcess.model.Vendor;

import jakarta.persistence.criteria.Predicate;

public class VendorSpecifications {
	public static Specification<Vendor> hasFields(String code) {
        return (root, query, builder) -> {
            String likeSearchTerm = "%" + code + "%";
            Predicate predicateVendorName= builder.like(root.get("vendorName"), likeSearchTerm);
            Predicate predicateLocation = builder.like(root.get("location"), likeSearchTerm);
            Predicate predicateEmail= builder.like(root.get("email"), likeSearchTerm);
            Predicate predicateMobile = builder.like(root.get("mobile"), likeSearchTerm);
           
            return builder.or(predicateVendorName, predicateLocation,predicateEmail,predicateMobile);
        };
    }

}
