package com.dawes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ResultadoVO;
import com.dawes.repository.ResultadoRepository;

@Service
public class ServicioResultadoImp implements ServicioResultado {
	
	@Autowired
	ResultadoRepository rr;

	@Override
	public <S extends ResultadoVO> S save(S entity) {
		return rr.save(entity);
	}

	@Override
	public Optional<ResultadoVO> findById(Integer id) {
		return rr.findById(id);
	}

	@Override
	public Iterable<ResultadoVO> findAll() {
		return rr.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		rr.deleteById(id);
	}

	@Override
	public void delete(ResultadoVO entity) {
		rr.delete(entity);
	}
	
	
}
