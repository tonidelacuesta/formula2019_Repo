package com.dawes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.PilotoVO;
import com.dawes.repository.PilotoRepository;

@Service
public class ServicioPilotoImp implements ServicioPiloto {

	@Autowired
	PilotoRepository pr;

	

	@Override
	public <S extends PilotoVO> S save(S entity) {
		return pr.save(entity);
	}



	@Override
	public Iterable<PilotoVO> findAll() {
		return pr.findAll();
	}



	@Override
	public void deleteById(Integer id) {
		pr.deleteById(id);
	}



	@Override
	public void delete(PilotoVO entity) {
		pr.delete(entity);
	}



	@Override
	public PilotoVO findByNombre(String nombre) {
		return pr.findByNombre(nombre);
	}
	
	
	
	
}
