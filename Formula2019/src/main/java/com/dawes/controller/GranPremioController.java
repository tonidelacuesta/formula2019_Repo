package com.dawes.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ApuestaVO;
import com.dawes.modelo.GranPremioVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.service.ServicioApuesta;
import com.dawes.service.ServicioGranPremio;
import com.dawes.service.ServicioPiloto;
import com.dawes.service.ServicioUsuario;

@Controller
@RequestMapping("/grandespremios")
public class GranPremioController {

	@Autowired
	ServicioGranPremio sgp;
	
	@Autowired
	ServicioApuesta sa;
	
	@Autowired
	ServicioUsuario su;
	
	@Autowired
	ServicioPiloto sp;
	
	@RequestMapping("/listaGrandesPremios")
	public String listaGrandesPremios(Model modelo) {
		
		modelo.addAttribute("listaGrandesPremios",sgp.findAll());
		return "admin/listaGrandesPremios";
		
	}
	
	@RequestMapping("/formInsertaGrandesPremios")
	public String formInsertaGrandesPremios(Model modelo) {
		
		modelo.addAttribute("granpremio", new GranPremioVO());
		modelo.addAttribute("listaGrandesPremios", sgp.findAll());
		return "admin/formInsertaGrandesPremios";
		
	}
	
	@RequestMapping("/insertaGrandesPremios")
	public String insertaGrandesPremios(@ModelAttribute GranPremioVO granpremio, Model modelo,@RequestParam String fecha,@RequestParam int gp_anterior) {
		
	String error="";
	
	granpremio.setFecha_carrera(LocalDate.parse(fecha,DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	
	granpremio.setGp_anterior(sgp.findById(gp_anterior).get());
		
		try {
			sgp.save(granpremio);
		}catch(Exception e) {
			e.getMessage();
			error = granpremio.getCiudad() + " ya existe, introduzca otro nombre";
		}
		
		modelo.addAttribute("listaGrandesPremios",sgp.findAll());
		modelo.addAttribute("error", error);
		return "admin/listaGrandesPremios";
		
	}
	
	@RequestMapping("/selectGrandesPremios")
	public String selectGrandesPremios(Model modelo) {
		
		String title = "Haz tu apuesta!";
		modelo.addAttribute("title",title);
		modelo.addAttribute("nombre_usuario", SecurityContextHolder.getContext().getAuthentication().getName());
		modelo.addAttribute("apuesta",new ApuestaVO());
		modelo.addAttribute("selectGrandesPremios",sgp.findAll());
		modelo.addAttribute("listaPilotos", sp.findAll());
		return "registrado/apostar";
		
	}
	
	@RequestMapping("/enviarApuesta")
	public String enviarApuesta(@ModelAttribute ApuestaVO apuesta, @RequestParam String vrapida, @RequestParam int carrera, @RequestParam String idpiloto1, @RequestParam String idpiloto2, @RequestParam String idpiloto3, Model modelo) {
		
		
		GranPremioVO granpremio = sgp.findById(carrera).get();
		String nombreJugador = SecurityContextHolder.getContext().getAuthentication().getName();
		UsuarioVO jugador = su.findUserAccount(nombreJugador);
		String mensaje_limite = "";
		boolean apuesta_abierta=true;
		
		//Para comprobar que no se ha sobrepasado el limite de fecha para apostar
		LocalDate limite = sgp.findById(carrera).get().getFecha_carrera();
		if(LocalDate.now().isAfter(limite)) {
			
			mensaje_limite = "No se pueden hacer más apuestas";
			apuesta_abierta = false;
			
		}else {
		
		GranPremioVO gp = sgp.findById(carrera).get();
		
		//cargamos una colección con las apuestas del jugador
		Set<ApuestaVO> apuestasdeljugador = sa.findAllByJugadorUserName(nombreJugador);
		
		//buscamos si el usuario ya ha hecho una apuesta sobre este granpremio
		
		Iterator<ApuestaVO> it = apuestasdeljugador.iterator();
		while(it.hasNext()) {
			ApuestaVO a = it.next();
			if(a.getCarrera().getCiudad() == gp.getCiudad()) {
				
				gp.removeApuesta(a);
				jugador.removeApuestaDelJugador(a);
				sgp.save(gp);
				sa.delete(a);
				
			}
		}
			//insertamos nueva apuesta y le asociamos el gran premio
				sa.save(apuesta);
				apuesta.setCarrera(granpremio);
				granpremio.addApuesta(apuesta);
				apuesta.setJugador(jugador);
				jugador.addApuestaDelJugador(apuesta);
				sa.save(apuesta);			
				sgp.save(granpremio);
				
				//asociamos el jugador
				
				
				
				//añadimos los pilotos a la apuesta
				apuesta.setPiloto1(idpiloto1);
				apuesta.setPiloto2(idpiloto2);
				apuesta.setPiloto3(idpiloto3);
				apuesta.setVRapida(vrapida);
				
				sa.save(apuesta);
			
		}
		//Resumen apuesta
		modelo.addAttribute("apuesta_abierta", apuesta_abierta);
		modelo.addAttribute("mensaje_limite", mensaje_limite);
		modelo.addAttribute("nombre_usuario", nombreJugador);
		modelo.addAttribute("carrera", granpremio.getCiudad());
		modelo.addAttribute("idpiloto1",idpiloto1);
		modelo.addAttribute("idpiloto2",idpiloto2);
		modelo.addAttribute("idpiloto3",idpiloto3);
		modelo.addAttribute("vrapida", vrapida);
		return "registrado/resumenApuesta";
		
	}
	
}
