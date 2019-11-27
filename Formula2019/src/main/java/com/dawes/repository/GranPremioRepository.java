package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;

import com.dawes.modelo.GranPremioVO;

public interface GranPremioRepository extends CrudRepository<GranPremioVO, Integer>{

	public GranPremioVO findByCiudad(String ciudad);
	
	
	
}
