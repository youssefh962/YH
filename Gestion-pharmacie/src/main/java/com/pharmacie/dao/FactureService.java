package com.pharmacie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.pharmacie.model.Facture;

@Service

public class FactureService {
	@Autowired
	private FactureRepository repo;
	
	public void savf(Facture facture) {
		repo.save(facture);
	}
	
	public Facture get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	

}
