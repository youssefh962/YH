package com.pharmacie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pharmacie.dao.ClientService;
import com.pharmacie.model.Client;

 



@Controller
public class ClientController {
	@Autowired
	private ClientService clientservice;
	
	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Client> listClients = clientservice.listAll(keyword);
		model.addAttribute("listClients", listClients);
		model.addAttribute("keyword", keyword);
		
		return "client/index";
	}

	@RequestMapping("/new")
	public String showNewClientForm(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		
		return "client/ajouter";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("client") Client client) {
		clientservice.save(client);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{idClient}")
	public ModelAndView showEditClientForm(@PathVariable(name = "idClient") Long idClient) {
		ModelAndView mav = new ModelAndView("client/modifier");
		
		Client client = clientservice.get(idClient);
		mav.addObject("client", client);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{idClient}")
	public String deleteClient(@PathVariable(name = "idClient") Long idClient) {
		clientservice.delete(idClient);
		
		return "redirect:/";
	}
	
}
