package com.dawes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.GranPremioVO;
import com.dawes.repository.GranPremioRepository;

@Service
public class ServicioGranPremioImp implements ServicioGranPremio {
	
	@Autowired
	GranPremioRepository gpr;

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioGranPremio#save(S)
	 */
	@Override
	public <S extends GranPremioVO> S save(S entity) {
		return gpr.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioGranPremio#findById(java.lang.Integer)
	 */
	@Override
	public Optional<GranPremioVO> findById(Integer id) {
		return gpr.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioGranPremio#findAll()
	 */
	@Override
	public Iterable<GranPremioVO> findAll() {
		return gpr.findAll();
	}

	/* (non-Javadoc)
	 * @see com.dawes.service.ServicioGranPremio#delete(com.dawes.modelo.GranPremioVO)
	 */
	@Override
	public void delete(GranPremioVO entity) {
		gpr.delete(entity);
	}
	@Override
	public GranPremioVO findByCiudad(String ciudad) {
		return gpr.findByCiudad(ciudad);
	}
	
	
	
}
