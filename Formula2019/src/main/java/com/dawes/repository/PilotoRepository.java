package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;

import com.dawes.modelo.PilotoVO;

public interface PilotoRepository extends CrudRepository<PilotoVO, Integer>{

	PilotoVO findByNombre(String nombre);
	
}
