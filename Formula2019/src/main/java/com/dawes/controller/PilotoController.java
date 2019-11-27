package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dawes.modelo.PilotoVO;
import com.dawes.service.ServicioPiloto;

@Controller
public class PilotoController {
	
	@Autowired
	ServicioPiloto sp;
	
	@RequestMapping("/selectPilotos")
	public String pilotos(Model modelo) {
		
		modelo.addAttribute("listaPilotos", sp.findAll());
		return "registrado/apostar";
	}
	
	@RequestMapping("/formInsertaPiloto")
	public String listaPilotos(Model modelo) {
		
		modelo.addAttribute("piloto", new PilotoVO());
		return "admin/formInsertaPiloto";
		
	}
	
	@RequestMapping("/insertaPiloto")
	public String insertaPiloto(@ModelAttribute PilotoVO piloto, Model modelo) {
		
		sp.save(piloto);
		
		modelo.addAttribute("listaPilotos", sp.findAll());
		return "admin/pilotos";
	}
	
	@RequestMapping("/listaPilotos")
	public String insertaPilotos(Model modelo) {
		
		modelo.addAttribute("listaPilotos", sp.findAll());
		return "admin/pilotos";
		
	}
	
}
