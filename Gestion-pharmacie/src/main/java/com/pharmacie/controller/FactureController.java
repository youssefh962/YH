package com.pharmacie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pharmacie.dao.ClientRepository;
import com.pharmacie.dao.FactureRepository;
import com.pharmacie.model.Client;
import com.pharmacie.model.Facture;


@Controller

public class FactureController {
	@Autowired
	private FactureRepository frepo;
	
	@Autowired
	private ClientRepository crepo;
	
	@GetMapping("/facture/new")
	public String showNewFactureForm(Model model) {
		List<Client> listclients=crepo.findAll();
 		model.addAttribute("facture", new Facture());
 		model.addAttribute("listclients", listclients);
		return "factures/new_facture";
	}
	
	
	@PostMapping("/facture/save")
	public String saveFacture(Facture facture) {
		
		frepo.save(facture);
		return "redirect:/facture";
	}
	
	
	@GetMapping("/facture")
	public String listFacture(Model model) {
		List<Facture> listfactures=frepo.findAll();
 		model.addAttribute("listfactures", listfactures);
		return "factures/facture";
	}
	
	
	@GetMapping("/facture/edit/{num}")
	public String showFactureEditForm(@PathVariable("num") long num, Model model) {
		model.addAttribute("facture", frepo.findById(num).get());

		return "factures/new_facture";
	}
	
	@GetMapping("/facture/delete/{num}")
	public String deletecommande(@PathVariable long num) {
		frepo.deleteById(num);
		return "factures/facture";
	}
	
	
	
	

}
