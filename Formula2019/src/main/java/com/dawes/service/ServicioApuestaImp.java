package com.dawes.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ApuestaVO;
import com.dawes.modelo.GranPremioVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repository.ApuestaRepository;

@Service
public class ServicioApuestaImp implements ServicioApuesta  {
	
	@Autowired
	ApuestaRepository ar;

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioApuesta#save(S)
	 */
	@Override
	public <S extends ApuestaVO> S save(S entity) {
		return ar.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioApuesta#findById(java.lang.Integer)
	 */
	@Override
	public Optional<ApuestaVO> findById(Integer id) {
		return ar.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioApuesta#findAll()
	 */
	@Override
	public Iterable<ApuestaVO> findAll() {
		return ar.findAll();
	}

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioApuesta#delete(com.dawes.modelo.ApuestaVO)
	 */
	@Override
	public void delete(ApuestaVO entity) {
		ar.delete(entity);
	}

	@Override
	public Set<ApuestaVO> findAllByCarrera(GranPremioVO carrera) {
		return ar.findAllByCarrera(carrera);
	}

	@Override
	public Set<ApuestaVO> findAllByJugadorUserName(String nombre) {
		return ar.findAllByJugadorUserName(nombre);
	}

	public ApuestaVO findByCarreraAndJugador(GranPremioVO gp, UsuarioVO jugador) {
		return ar.findByCarreraAndJugador(gp, jugador);
	}

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioApuesta#findByJugadoresJugadorNombre(java.lang.String)
	 */
	
	
	
	
	
	
	
	
}
