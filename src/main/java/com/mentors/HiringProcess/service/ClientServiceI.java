package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.ClientDto;

public interface ClientServiceI {

	void addClient(ClientDto clientDto);

	List<ClientDto> allClients();

	List<String> allClientNames();

	void updateClient(Long id, ClientDto clientDto);

	void deleteClient(Long id);

}
