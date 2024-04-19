package com.mentors.HiringProcess.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mentors.HiringProcess.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
