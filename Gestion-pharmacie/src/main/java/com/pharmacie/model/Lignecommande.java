package com.pharmacie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lignecommande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long num;
	private int qte;
	@ManyToOne   @JoinColumn(name="CODE_FACTURE") 
	private Facture facture;
	@ManyToOne   @JoinColumn(name="CODE_MEDICAMENT") 
	private Medicament medicament;
	public Lignecommande() {
		 
	}
	public Lignecommande(int qte, Facture facture, Medicament medicament) {
		super();
		this.qte = qte;
		this.facture = facture;
		this.medicament = medicament;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public Medicament getMedicament() {
		return medicament;
	}
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	
	

}
