package com.apiclients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apiclients.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Query("select c from clients c where c.name like %?1%")
	public List<Client> findLikeName(String name);
}