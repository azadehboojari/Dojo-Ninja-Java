package com.codingdojo.dojo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojo.models.Dojo;
@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	ArrayList<Dojo> findAll();
	ArrayList<Dojo> findByName(String Name);
}
