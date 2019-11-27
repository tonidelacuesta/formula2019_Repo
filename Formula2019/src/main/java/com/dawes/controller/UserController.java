package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.repository.UserRepository;
import com.dawes.service.ServicioApuesta;

@Controller
public class UserController {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	ServicioApuesta sa;

	@RequestMapping("/clasificacion")
	public String clasificacion(Model modelo){
		
		String nombreJugador = SecurityContextHolder.getContext().getAuthentication().getName();
		
		modelo.addAttribute("listaUsuarios", ur.listarUsuarios());
		modelo.addAttribute("nombre_usuario", nombreJugador);
		
		return("registrado/clasificacion");
	}
	
	@RequestMapping("/detalle_jugador")
	public String detalleJugador(Model modelo, @RequestParam String userName) {
		
		
		modelo.addAttribute("aciertos", sa.findAllByJugadorUserName(userName));
		modelo.addAttribute("jugador", userName);
		return "registrado/detalleJugador";
	}
	
}
