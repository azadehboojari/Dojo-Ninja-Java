package com.codingdojo.dojo.controllers;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojo.models.Dojo;
import com.codingdojo.dojo.models.Ninjas;
import com.codingdojo.dojo.services.DojoService;
import com.codingdojo.dojo.services.NinjaService;

@Controller

public class DojoController {
	

		private final DojoService dS;
		private final NinjaService nS;
	
		
		public DojoController(DojoService dS, NinjaService nS) {
			this.dS=dS;
			this.nS=nS;

		}
		@RequestMapping("/")
		public String index(Model model) {
			ArrayList<Dojo> dojo=dS.allDojos();
			model.addAttribute("dojo", dojo);
			return "index.jsp";
		}
		@GetMapping("/dojo/new")
		public String create(@ModelAttribute("dojo") Dojo dojo) {
			return "new.jsp";
		}
		
		@PostMapping("/dojo/new")
		public String create(@ModelAttribute("dojo") Dojo dojo, BindingResult res) {
			if(res.hasErrors()) {
				return "new.jsp";
			}
			Dojo d=dS.createDojo(dojo);
			return "redirect:/";
		}
		@GetMapping("/dojo/{id}")
	    public String show(@PathVariable ("id") Long id, Model model) {
	    	Dojo dojo= dS.findDojo(id);
	    	model.addAttribute("dojo", dojo);
	    	return "show.jsp";
	    }

}
