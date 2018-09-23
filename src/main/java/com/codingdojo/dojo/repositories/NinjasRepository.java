package com.codingdojo.dojo.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojo.models.Ninjas;

@Repository
public interface NinjasRepository extends CrudRepository <Ninjas, Long>{
//	String findTopByOrderByIdDesc(Long dojoId);
}
