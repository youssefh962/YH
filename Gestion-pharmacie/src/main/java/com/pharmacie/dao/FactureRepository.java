package com.pharmacie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacie.model.Facture;

 
public interface FactureRepository extends JpaRepository<Facture,Long> {

}
