package com.pharmacie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

 
import com.pharmacie.model.Medicament;
 

public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
	@Query("SELECT m FROM Medicament m WHERE CONCAT(m.name, ' ', m.description) LIKE %?1%")
	public List<Medicament> search(String keyword);

}
