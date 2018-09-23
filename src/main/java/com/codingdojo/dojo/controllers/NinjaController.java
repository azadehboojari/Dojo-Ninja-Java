package com.codingdojo.dojo.controllers;

import java.util.ArrayList;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojo.models.Dojo;
import com.codingdojo.dojo.models.Ninjas;
import com.codingdojo.dojo.services.DojoService;
import com.codingdojo.dojo.services.NinjaService;

@Controller

public class NinjaController {
	
	
		private final NinjaService nS;
		private final DojoService dS;
		
		public NinjaController(NinjaService nS, DojoService dS) {
			this.nS=nS;
			this.dS=dS;
		}
		
		@GetMapping ("/ninja/new")
		public String ninjas (@ModelAttribute("ninjas") Ninjas ninjas, Model model) {
			ArrayList<Dojo> dojo= dS.allDojos();
			model.addAttribute("dojo", dojo);
			return "ninja.jsp";
		}
		
		@PostMapping("/ninja/new")
		public String create(@Valid @ModelAttribute("ninjas") Ninjas ninjas, BindingResult res) {
			if( res.hasErrors() ){
				return "ninja.jsp";
			}else{
				
				nS.createNinja(ninjas);
				return "redirect:/";
			}
		}
		
}
