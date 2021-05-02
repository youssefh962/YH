package com.pharmacie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacie.model.Medicament;

@Service
public class MedicamentService {
	
	@Autowired
	private MedicamentRepository repo;
	
	public List<Medicament> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}
	
	public void save(Medicament medicament) {
		repo.save(medicament);
	}
	
	public Medicament get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
