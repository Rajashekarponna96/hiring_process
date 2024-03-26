package com.mentors.HiringProcess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
