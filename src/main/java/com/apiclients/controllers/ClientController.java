package com.apiclients.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiclients.entities.Client;
import com.apiclients.service.ClientService;

@RestController
@RequestMapping("clients")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@GetMapping()
	public List<Client> clients() {
		return service.findAll();
	}
	
	@PostMapping()
	public void saveClient(Client client) {
		service.save(client);
	}
	
	@DeleteMapping(value="{id}")
	public String deleteClient(@PathVariable ("id") Long id) {
		service.delete(id);
		
		return "/clientes.html";
	}
}