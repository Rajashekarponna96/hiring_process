package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.dto.RecruiterDto;
import com.mentors.HiringProcess.service.ClientServiceI;

@RestController
@RequestMapping(value = "/client")
@CrossOrigin
public class ClientController {
	
	@Autowired
	private ClientServiceI clientServiceI;
	
	@PostMapping("/")
	public void addClient(@RequestBody ClientDto  clientDto) {
		clientDto.validateRequiredAttibutes(clientDto);
		clientServiceI.addClient(clientDto);
	}
	
	@GetMapping("/all")
	public List<ClientDto> allClients() {
		return clientServiceI.allClients();
	}
	
	
	@GetMapping("/allclientnames")
	public List<String> allClientNames() {
	    return clientServiceI.allClientNames();
	}

	
	@PutMapping("/{id}")
	public void updateClient(@PathVariable Long id,  @RequestBody ClientDto  clientDto) {
		clientServiceI.updateClient(id,clientDto);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable Long id) {
		clientServiceI.deleteClient(id);
	}
	
	@GetMapping("/searchpage")
	public Page<ClientDto> getAllLients(@RequestParam int page, @RequestParam int size,
	        @RequestParam String code) {
	    Pageable pageable = PageRequest.of(page, size);
	    return clientServiceI.getAllClients(pageable,code);
	}
	
	@GetMapping("/clientlistwithpagination")
	public Page<ClientDto> getAllClientsWithPagination(@RequestParam int page, @RequestParam int size) {
	    //Pageable pageable = PageRequest.of(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdTimestamp"));
	    return clientServiceI.getAllClientsWithPagination(pageable);
	}
	
	


}
