package com.dawes.service;

import com.dawes.modelo.PilotoVO;

public interface ServicioPiloto {

	<S extends PilotoVO> S save(S entity);

	Iterable<PilotoVO> findAll();

	void deleteById(Integer id);

	void delete(PilotoVO entity);

	PilotoVO findByNombre(String nombre);

}