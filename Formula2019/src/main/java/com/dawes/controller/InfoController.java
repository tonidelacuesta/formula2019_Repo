package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.repository.UserRepository;

@Controller
public class InfoController {
	
	@Autowired
	UserRepository ur;

	@RequestMapping("/userInfo")
	public String userInfo(Model modelo) {

		modelo.addAttribute("nombre_usuario", SecurityContextHolder.getContext().getAuthentication().getName());
		return "fragmentos";
	}
	
	@RequestMapping("/cambiarContra")
	public String cambiarContra(Model modelo) {
		
		modelo.addAttribute("nombre_usuario", SecurityContextHolder.getContext().getAuthentication().getName());
		
		return "formPassword";
		
	}
	
	@RequestMapping("/nuevaContra")
	public String nuevaContra(@RequestParam String contra1, @RequestParam String contra2,  Model modelo) {
		
		String error="La contraseña no coincide, vuelve a intentarlo";
		
		if(contra1.equals(contra2)) {
			
			String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
			String encrited = encrytePassword(contra1);
			modelo.addAttribute("nombre_usuario", nombre );
			modelo.addAttribute("contra",encrited);
			ur.cambiarContra(encrited,nombre);
			error= "La contraseña ha sido cambiada con éxito";
			modelo.addAttribute("error",error);
			
		}else {
			
			modelo.addAttribute("error",error);
		
		}
		
		return "passwordCambiada";
	
	}
	
	
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
	
}
