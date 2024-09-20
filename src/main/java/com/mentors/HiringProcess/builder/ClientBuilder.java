package com.mentors.HiringProcess.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.dto.JobDto;
import com.mentors.HiringProcess.model.Client;
import com.mentors.HiringProcess.model.Job;
@Component
public class ClientBuilder {
	
	@Autowired
	private PocBuilder pocBuilder;

	public Client toModel(ClientDto clientDto) {

		Client client = new Client();
		client.setId(clientDto.getId());
		client.setCompanyName(clientDto.getCompanyName());
		client.setLocation(clientDto.getLocation());
		client.setCreatedTimestamp(clientDto.getCreatedTimestamp());
		client.setModifiedTimestamp(clientDto.getModifiedTimestamp());
		
		client.setPocs(pocBuilder.toModelList(clientDto.getPocs()).stream().peek(e->e.setClient(client)).collect(Collectors.toList()));
		return client;
	}
	
    public ClientDto toDto(Client client) {
		
	    ClientDto clientDto= new ClientDto();
	    clientDto.setId(client.getId());
	    clientDto.setCompanyName(client.getCompanyName());
	    clientDto.setLocation(client.getLocation());
	    clientDto.setCreatedTimestamp(client.getCreatedTimestamp());
	    clientDto.setModifiedTimestamp(client.getModifiedTimestamp());
	    clientDto.setPocs(pocBuilder.toDtoList(client.getPocs()));
	    
//	    List<JobDto> jobDtos = new ArrayList<>();
//	    for (Job job : client.getJob()) {
//	    	JobDto jobDto = new JobDto();
//	    	jobDto.setId(job.getId());
//	    	jobDtos.add(jobDto);
//	    }
//	    clientDto.setJobs(jobDtos);
	    
		return clientDto;
    }
    
    
}
