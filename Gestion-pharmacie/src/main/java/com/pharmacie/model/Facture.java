package com.pharmacie.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
 
@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long num;
	private String date;
	private double tva;
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	@OneToMany(mappedBy="facture")
	private Collection<Lignecommande> lignes;
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(long num, String date, double tva, Client client, Collection<Lignecommande> lignes) {
		super();
		this.num = num;
		this.date = date;
		this.tva = tva;
		this.client = client;
		this.lignes = lignes;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Collection<Lignecommande> getLignes() {
		return lignes;
	}
	public void setLignes(Collection<Lignecommande> lignes) {
		this.lignes = lignes;
	}
	
	 
	public void addLigne(long num, int qte )
	{
		lignes.add(new Client(num, qte, this));
	}
	
	
	
}
