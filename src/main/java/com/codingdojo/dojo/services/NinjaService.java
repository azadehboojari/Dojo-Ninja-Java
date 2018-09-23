package com.codingdojo.dojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.Ninjas;
import com.codingdojo.dojo.repositories.NinjasRepository;
@Service
public class NinjaService {
	private final NinjasRepository nr;
	
	public NinjaService (NinjasRepository nr) {
		this.nr=nr;
	}
	
	public ArrayList<Ninjas> allNinjas(){
		return (ArrayList<Ninjas>)nr.findAll();
	}
	
	public Ninjas createNinja(Ninjas n) {
		return nr.save(n);
	}
	public Ninjas findNinja(Long id) {
		Optional<Ninjas> optionalNinja = nr.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
//	public String count(Long d) {
//		return nr.findTopByOrderByIdDesc(d);
//	}


}
