package com.dawes.service;

import com.dawes.modelo.UsuarioVO;

public interface ServicioUsuario {

	UsuarioVO findUserAccount(String userName);

	
}