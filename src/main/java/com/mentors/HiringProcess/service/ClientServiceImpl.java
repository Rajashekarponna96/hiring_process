package com.mentors.HiringProcess.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.ClientBuilder;
import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.Client;
import com.mentors.HiringProcess.model.Recruiter;
import com.mentors.HiringProcess.repository.ClientRepository;
import com.mentors.HiringProcess.specification.ClientSprecifications;
import com.mentors.HiringProcess.specification.RecruiterSpecifications;
@Service
@Transactional
public class ClientServiceImpl implements ClientServiceI{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientBuilder clientBuilder;

	@Override
	public void addClient(ClientDto clientDto) {
		clientDto.setCreatedTimestamp(LocalDateTime.now());
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
	
//	 @Override
//	    public List<String> allClientNames() {
//	        List<String> clientNames = new ArrayList<>();
//	        List<Client> clients = clientRepository.findAll();
//	        if (clients != null) {
//	            clients.forEach(client -> {
//	                clientNames.add(client.getCompanyName()); // Assuming getName() method exists in your Client class
//	            });
//	        }
//	        return clientNames;
//	    }
	@Override
	public List<String> allClientNames() {
	    List<String> clientNames = new ArrayList<>();
	    List<Client> clients = clientRepository.findAll();
	    if (clients != null) {
	        clients.forEach(client -> {
	            clientNames.add(client.getCompanyName()); // Assuming getCompanyName() method exists in your Client class
	        });
	    }
	    return clientNames;
	}

	@Override
	public Page<ClientDto> getAllClients(Pageable pageable, String code) {
		Specification<Client> spec = Specification.where(null); // Start with an empty specification

        if (code != null && !code.isEmpty()) {
            spec = spec.and(ClientSprecifications.hasFields(code));
        }

        Page<Client> recruiterPage = clientRepository.findAll(spec, pageable);
        return recruiterPage.map(clientBuilder::toDto);
    }

	@Override
	public Page<ClientDto> getAllClientsWithPagination(Pageable pageable) {
		Page<Client> clientPage = clientRepository.findAll(pageable);
        return clientPage .map(clientBuilder::toDto);
	}
	


}
