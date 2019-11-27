package com.dawes.service;

import java.util.Optional;

import com.dawes.modelo.ResultadoVO;

public interface ServicioResultado {

	<S extends ResultadoVO> S save(S entity);

	Optional<ResultadoVO> findById(Integer id);

	Iterable<ResultadoVO> findAll();

	void deleteById(Integer id);

	void delete(ResultadoVO entity);

}