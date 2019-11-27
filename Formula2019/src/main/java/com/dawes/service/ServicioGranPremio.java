package com.dawes.service;

import java.util.Optional;

import com.dawes.modelo.GranPremioVO;

public interface ServicioGranPremio {

	<S extends GranPremioVO> S save(S entity);

	Optional<GranPremioVO> findById(Integer id);

	Iterable<GranPremioVO> findAll();

	void delete(GranPremioVO entity);

	GranPremioVO findByCiudad(String ciudad);

}