package com.dawes.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.dawes.modelo.ApuestaVO;
import com.dawes.modelo.GranPremioVO;
import com.dawes.modelo.UsuarioVO;

public interface ServicioApuesta {

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioApuesta#save(S)
	 */
	<S extends ApuestaVO> S save(S entity);

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioApuesta#findById(java.lang.Integer)
	 */
	Optional<ApuestaVO> findById(Integer id);

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioApuesta#findAll()
	 */
	Iterable<ApuestaVO> findAll();

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioApuesta#delete(com.dawes.modelo.ApuestaVO)
	 */
	void delete(ApuestaVO entity);

	Set<ApuestaVO> findAllByCarrera(GranPremioVO carrera);

	Set<ApuestaVO> findAllByJugadorUserName(String nombre);
	
	ApuestaVO findByCarreraAndJugador(GranPremioVO gp, UsuarioVO jugador);

}