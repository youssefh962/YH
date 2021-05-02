package com.pharmacie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pharmacie.dao.MedicamentService;
import com.pharmacie.model.Medicament;

 
@Controller
public class MedicamentController {
	@Autowired
	private MedicamentService medicamentservice;
	
	@RequestMapping("/medicament")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Medicament> listMedicaments = medicamentservice.listAll(keyword);
		model.addAttribute("listMedicaments", listMedicaments);
		model.addAttribute("keyword", keyword);
		
		return "medicaments/index";
	}
 
	
	@RequestMapping("/newmedicament")
	public String showNewMedicamentForm(Model model) {
		Medicament medicament = new Medicament();
		model.addAttribute("medicament", medicament);
		
		return "medicaments/ajouter_medicament";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveMedicament(@ModelAttribute("medicament") Medicament medicament) {
		medicamentservice.save(medicament);
		
		return "redirect:/medicament";
	}
	
 	@RequestMapping("/update/{id}")
 	public ModelAndView showEditMedicamentForm(@PathVariable(name = "id") Long id) {
 		ModelAndView mavv = new ModelAndView("medicaments/update");
 		
 		Medicament medicament =medicamentservice.get(id);
 		mavv.addObject("medicament", medicament);
 		
 		return mavv;
 	}	
 	
	 
	
	
	@RequestMapping("/del/{id}")
	public String deleteMedicament(@PathVariable(name = "id") Long id) {
		medicamentservice.delete(id);
		
		return "redirect:/medicament";
	}
	
	
	 

}
