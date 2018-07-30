package com.apiclients.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apiclients.entities.Client;
import com.apiclients.repository.ClientRepository;

@Service
@Transactional
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client save(Client client) {
		return repository.save(client);		
	}

	public List<Client> findAll() {
		return repository.findAll(Sort.by(Direction.ASC, "id"));
	}
	
	public Optional<Client> findOne(Long id) {
		return repository.findById(id);
	}	
	
	public void delete(Long id) {
		repository.deleteById(id);		
	}
	
	public void deleteAllClients(List<Client> clients) {
		repository.deleteAll(clients);
	}

	public List<Client> findLikeName(String name) {
		return repository.findLikeName(name);
	}
}
