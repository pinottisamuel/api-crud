package com.apiclients.builders;

import java.util.ArrayList;
import java.util.List;

import com.apiclients.entities.Client;

public class ClientBuilder {
	
	private static Client newClient(String name){
		
		return new Client(name);			
	}
	
	public static List<Client> createClients(int count, String name) {
		
		List<Client> clients = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			clients.add(newClient(name + i));
		}
		
		return clients;
	}
}