package com.dawes.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.dawes.modelo.ApuestaVO;
import com.dawes.modelo.GranPremioVO;
import com.dawes.modelo.UsuarioVO;

public interface ApuestaRepository extends CrudRepository<ApuestaVO, Integer>{

//	public ApuestaVO findByJugadoresJugadorNombre(String nombre);
//	
	public Set<ApuestaVO> findAllByJugadorUserName(String nombre);

	public ApuestaVO findByCarreraAndJugador(GranPremioVO gp, UsuarioVO jugador);
	
	public Set<ApuestaVO> findAllByCarrera(GranPremioVO carrera);
}
