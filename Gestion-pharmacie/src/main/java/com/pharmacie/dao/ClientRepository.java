package com.pharmacie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pharmacie.model.Client;


public interface ClientRepository extends JpaRepository<Client,Long> {
	
	@Query("SELECT p FROM Client p WHERE CONCAT(p.nom, ' ', p.prenom, ' ', p.raisonsociale, ' ', p.adresse, p.ice, ' ', p.mail) LIKE %?1%")
	public List<Client> search(String keyword);

}
