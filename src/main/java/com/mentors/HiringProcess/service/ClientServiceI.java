package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.ClientDto;

public interface ClientServiceI {

	void addClient(ClientDto clientDto);

	List<ClientDto> allClients();

	List<String> allClientNames();

	void updateClient(Long id, ClientDto clientDto);

	void deleteClient(Long id);
	
	Page<ClientDto> getAllClients(Pageable pageable, String code);
	
	Page<ClientDto> getAllClientsWithPagination(Pageable pageable);

}
