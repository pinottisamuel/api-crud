package com.apiclients.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apiclients.builders.ClientBuilder;
import com.apiclients.entities.Client;
import com.apiclients.service.ClientService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClientRepositoryTest {
	
	@Autowired
	private ClientService service;	
	
	private List<Client> clients = new ArrayList<>();	
	private int numberOfClients = 4;
	private String nameOfClients = "Test create ";
	
	@Before
	public void newClients() {
		
		clients = ClientBuilder.createClients(numberOfClients, nameOfClients);	
		clients.forEach(client -> service.save(client));
	}
	
	@After
	public void destroyer() {
		
//		clients.forEach(client -> service.delete(client.getId()));
		
		service.deleteAllClients(clients);
	}
	
	@Test
	public void listAllClients() {		
		
		List<Client> clientsSaved = service.findAll();
		
		Assert.assertEquals(clientsSaved.size(), numberOfClients);		
		assertThat(clientsSaved).extracting("name").contains(nameOfClients.concat("1"));		
	}
	
	@Test
	public void listClientLikeName() {
		
		List<Client> clientsFound = service.findLikeName(nameOfClients);
		
		Assert.assertEquals(clientsFound.size(), numberOfClients);				
	}
}
