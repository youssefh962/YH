package com.pharmacie.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
	private String nom;
	private String prenom;
	private String raisonsociale;
	private String adresse;
	private String ice;
	private String mail;
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Facture> factures;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(Long idClient, String nom, String prenom, String raisonsociale, String adresse, String ice,
			String mail, Collection<Facture> factures) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.raisonsociale = raisonsociale;
		this.adresse = adresse;
		this.ice = ice;
		this.mail = mail;
		this.factures = factures;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRaisonsociale() {
		return raisonsociale;
	}
	public void setRaisonsociale(String raisonsociale) {
		this.raisonsociale = raisonsociale;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getIce() {
		return ice;
	}
	public void setIce(String ice) {
		this.ice = ice;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Collection<Facture> getFactures() {
		return factures;
	}
	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
}
