package com.dawes.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ApuestaVO;
import com.dawes.modelo.GranPremioVO;
import com.dawes.modelo.ResultadoVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repository.UserRepository;
import com.dawes.service.ServicioApuesta;
import com.dawes.service.ServicioGranPremio;
import com.dawes.service.ServicioPiloto;
import com.dawes.service.ServicioResultado;


@Controller
@RequestMapping("/apuestas")
public class ApuestaController {
	
	@Autowired
	ServicioApuesta sa;
	
	@Autowired
	ServicioGranPremio sgp;
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	ServicioPiloto sp;
	
	@Autowired
	ServicioResultado sr;
	
	@RequestMapping("/insertResultado")
	public String insertResultado(Model modelo) {
		
		modelo.addAttribute("listaPilotos", sp.findAll());
		modelo.addAttribute("selectGrandesPremios",sgp.findAll());
		return "admin/formResultadoCarrera";
		
	}
	
	@RequestMapping("/resultadoCarrera")
	public String resultadoCarrera(Model modelo, @RequestParam String vrapida, @RequestParam String carrera, @RequestParam String idpiloto1, @RequestParam String idpiloto2, @RequestParam String idpiloto3) {
	
//	Antes de comprobar los resultado vamos a copiar las apuestas del premio anterior de aquellos
//	jugadores que no hayan apostado
		
				GranPremioVO gp = sgp.findByCiudad(carrera);
				
				if(gp.getGp_anterior() != null) {
		
					List<UsuarioVO> listadoUsuarios = ur.listarUsuarios();
					
					for(UsuarioVO u : listadoUsuarios) {
						
						//si no se encuentra apuesta de algún judador sobre el gran premio...
						if(sa.findByCarreraAndJugador(gp, u) == null) {
							
							//buscamos la apuesta que hizo en el gran premio anterior
							ApuestaVO a = sa.findByCarreraAndJugador(gp.getGp_anterior(), u);
							ApuestaVO b = new ApuestaVO();
							
							if(a != null) {
								
								//creamos una apuesta con los datos de la apuesta anterior y la guardamos
								b.setCarrera(gp);
								b.setJugador(a.getJugador());
								b.setPiloto1(a.getPiloto1());
								b.setPiloto2(a.getPiloto2());
								b.setPiloto3(a.getPiloto3());
								b.setVRapida(a.getVRapida());
								sa.save(b);
							
							}
						}
					}
				}
		
//Desde aquí código para calcular los aciertos	
				
		Set<ApuestaVO> apuestas_semana = sa.findAllByCarrera(gp);
		ResultadoVO resultado_carrera = new ResultadoVO(idpiloto1,idpiloto2,idpiloto3,vrapida, LocalDate.now(),gp);
		
	
		for(ApuestaVO ap : apuestas_semana) {
			
			int puntosActualesDelJugador = ap.getJugador().getPuntos();

			if(ap.getPiloto1().equalsIgnoreCase(idpiloto1)) {
				
				
				puntosActualesDelJugador+=25;
				ap.setAcierto_primero(25);
			
			}
			
			if(ap.getPiloto2().equalsIgnoreCase(idpiloto2)) {
				
				
				puntosActualesDelJugador+=18;
				ap.setAcierto_segundo(18);
			}
			
			if(ap.getPiloto3().equalsIgnoreCase(idpiloto3)) {
				
				
				puntosActualesDelJugador+=15;
				ap.setAcierto_tercero(15);
				
			}
			
			if(ap.getVRapida().equalsIgnoreCase(vrapida)) {
				
				
				puntosActualesDelJugador+=1;
				ap.setAcierto_vrapida(1);
				
			}
			
			ur.sumarPuntos(puntosActualesDelJugador, ap.getJugador().getUserId());
			gp.addResultado(resultado_carrera);
			sr.save(resultado_carrera);
			sgp.save(gp);
			sa.save(ap);
		}
			
			
			
		modelo.addAttribute("mensaje", "Resultado enviado");
		return "admin/formResultadoCarrera";
		
	}
	
	@RequestMapping("/formAnularResultado")
	public String formAnularResultado(Model modelo) {
		
		modelo.addAttribute("listadoCarreras", sgp.findAll());
		
		return "admin/anularResultado";
	}
	
	@RequestMapping("/anularResultado")
	public String anularResultado(Model modelo, @RequestParam String carrera) {
		
		GranPremioVO gp = sgp.findByCiudad(carrera);
		Set<ApuestaVO> listadoApuestas = sa.findAllByCarrera(gp);
		
		for(ApuestaVO ap: listadoApuestas) {
			
			int puntos_ganados = ap.getAcierto_primero() + ap.getAcierto_segundo() + ap.getAcierto_tercero() + ap.getAcierto_vrapida();
			UsuarioVO u = ap.getJugador();
			int puntos_actuales = u.getPuntos();
			
			u.setPuntos(puntos_actuales - puntos_ganados);
			sa.delete(ap);
		}
		
		modelo.addAttribute("mensaje", "Se han restado los puntos ganados en el Gran Premio");
		
		return "admin/anularResultado";
	}
	
		
}			

	