package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.service.ClientServiceI;

@RestController
@RequestMapping(value = "/client")
@CrossOrigin
public class ClientController {
	
	@Autowired
	private ClientServiceI clientServiceI;
	
	@PostMapping("/")
	public void addClient(@RequestBody ClientDto  clientDto) {
		//clientDto.validateRequiredAttibutes(clientDto);
		clientServiceI.addClient(clientDto);
	}
	
	@GetMapping("/all")
	public List<ClientDto> allClients() {
		return clientServiceI.allClients();
	}
	
	
	@PutMapping("/{id}")
	public void updateClient(@PathVariable Long id,  @RequestBody ClientDto  clientDto) {
		clientServiceI.updateClient(id,clientDto);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable Long id) {
		clientServiceI.deleteClient(id);
	}

}
