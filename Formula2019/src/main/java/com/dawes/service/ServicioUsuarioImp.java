package com.dawes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioVO;
import com.dawes.repository.UserRepository;

@Service
public class ServicioUsuarioImp implements ServicioUsuario {
	
	@Autowired
	UserRepository ur;

	@Override
	public UsuarioVO findUserAccount(String userName) {
		return ur.findUserAccount(userName);
	}

	
	 
}
