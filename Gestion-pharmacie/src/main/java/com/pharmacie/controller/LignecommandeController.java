package com.pharmacie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

 import com.pharmacie.dao.FactureRepository;
import com.pharmacie.dao.LignecommandeRepository;
import com.pharmacie.dao.MedicamentRepository;
import com.pharmacie.model.Facture;
import com.pharmacie.model.Lignecommande;
import com.pharmacie.model.Medicament;


@Controller

public class LignecommandeController {
	@Autowired
	private LignecommandeRepository lrepo;
	
	@Autowired
	private FactureRepository frepo;
	@Autowired
	private MedicamentRepository mrepo;
	
	@GetMapping("/commande/new")
	public String showNewCommandeForm(Model model) {
		List<Facture> listfactures=frepo.findAll();
		List<Medicament> listmedicaments=mrepo.findAll();
 		model.addAttribute("lignecommandes", new Lignecommande());
 		model.addAttribute("listfactures", listfactures);
 		model.addAttribute("listmedicaments", listmedicaments);
		return "commande/new_commande";
	}
	
	
	@PostMapping("/commande/save")
	public String saveCommande(Lignecommande lignecommandes) {
		
		lrepo.save(lignecommandes);
		return "redirect:/commande";
	}
	
	
	@GetMapping("/commande")
	public String listComande(Model model) {
		List<Lignecommande> lignecommandes=lrepo.findAll();
 		model.addAttribute("lignecommandes", lignecommandes);
		return "commande/commande";
	}
	
	
	@GetMapping("/commande/edit/{num}")
	public String showComandeEditForm(@PathVariable("num") long num, Model model) {
		model.addAttribute("commande", lrepo.findById(num).get());

		return "commande/new_commande";
	}
	
	@GetMapping("/commande/delete/{num}")
	public String deletecommande(@PathVariable long num) {
		lrepo.deleteById(num);
		return "commande/commande";
	}
	
	
	
	

}
