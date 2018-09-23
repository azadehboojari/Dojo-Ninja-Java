package com.codingdojo.dojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.Dojo;
import com.codingdojo.dojo.repositories.DojoRepository;
@Service

public class DojoService {
	private final DojoRepository dr;
	
	
	public DojoService (DojoRepository dr) {
		this.dr=dr;	
	}
	
	public ArrayList<Dojo> allDojos(){
		return dr.findAll();
	}
	public Dojo createDojo(Dojo dojo) {
		return dr.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dr.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	public Integer counter() {
		return (int) dr.count();
	}

}
