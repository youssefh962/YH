package com.pharmacie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacie.model.Client;

 

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	public List<Client> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}
	
	public void save(Client client) {
		repo.save(client);
	}
	
	public Client get(Long idClient) {
		return repo.findById(idClient).get();
	}
	
	public void delete(Long idClient) {
		repo.deleteById(idClient);
	}

}
