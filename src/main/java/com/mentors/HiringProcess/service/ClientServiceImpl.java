package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.ClientBuilder;
import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.model.Client;
import com.mentors.HiringProcess.repository.ClientRepository;
@Service
@Transactional
public class ClientServiceImpl implements ClientServiceI{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientBuilder clientBuilder;

	@Override
	public void addClient(ClientDto clientDto) {
		clientRepository.save(clientBuilder.toModel(clientDto));
		
	}

	@Override
	public List<ClientDto> allClients() {
		List<ClientDto> clientsList = new ArrayList<>();
		List<Client> clients = clientRepository.findAll();
		if (clients != null) {
			clients.forEach(client -> {
				clientsList.add(clientBuilder.toDto(client));
			});
		}
		return clientsList;
	}

	@Override
	public void updateClient(Long id, ClientDto clientDto) {
		Optional<Client> dbclient = clientRepository.findById(id);
		if (dbclient.isPresent()) {
			clientRepository.save(clientBuilder.toModel(clientDto));
		}
		
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
		
	}

}
