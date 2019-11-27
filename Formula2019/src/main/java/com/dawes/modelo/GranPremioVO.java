package com.dawes.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="grandespremios")
public class GranPremioVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idgranpremio;
	
	@Column(unique=true)
	private String ciudad;
	 
	private LocalDate fecha_carrera;
	
	@OneToMany(mappedBy="carrera")
	private Set<ApuestaVO> apuestasDelGranPremio = new HashSet<ApuestaVO>();
	
	@OneToMany(mappedBy="gp")
	private Set<ResultadoVO> resultadosDelGranPremio = new HashSet<ResultadoVO>();

	@OneToOne
	private GranPremioVO gp_anterior;
	
	public GranPremioVO(int idgranpremio, String ciudad, LocalDate fecha_carrera, Set<ApuestaVO> apuestasDelGranPremio,
			Set<ResultadoVO> resultadosDelGranPremio, GranPremioVO gp_anterior) {
		super();
		this.idgranpremio = idgranpremio;
		this.ciudad = ciudad;
		this.fecha_carrera = fecha_carrera;
		this.apuestasDelGranPremio = apuestasDelGranPremio;
		this.resultadosDelGranPremio = resultadosDelGranPremio;
		this.gp_anterior = gp_anterior;
	}


	public GranPremioVO(String ciudad, LocalDate fecha_carrera, Set<ApuestaVO> apuestasDelGranPremio,
			Set<ResultadoVO> resultadosDelGranPremio, GranPremioVO gp_anterior) {
		super();
		this.ciudad = ciudad;
		this.fecha_carrera = fecha_carrera;
		this.apuestasDelGranPremio = apuestasDelGranPremio;
		this.resultadosDelGranPremio = resultadosDelGranPremio;
		this.gp_anterior = gp_anterior;
	}

	public GranPremioVO() {
		super();
	}

	public int getIdgranpremio() {
		return idgranpremio;
	}

	public void setIdgranpremio(int idgranpremio) {
		this.idgranpremio = idgranpremio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LocalDate getFecha_carrera() {
		return fecha_carrera;
	}

	public void setFecha_carrera(LocalDate fecha_carrera) {
		this.fecha_carrera = fecha_carrera;
	}

	public Set<ApuestaVO> getApuestasDelGranPremio() {
		return apuestasDelGranPremio;
	}

	public void setApuestasDelGranPremio(Set<ApuestaVO> apuestasDelGranPremio) {
		this.apuestasDelGranPremio = apuestasDelGranPremio;
	}
	
	public Set<ApuestaVO> addApuesta(ApuestaVO apuesta){
		
		 this.apuestasDelGranPremio.add(apuesta);
		 
		 return apuestasDelGranPremio;
	}
	
	public Set<ApuestaVO> removeApuesta (ApuestaVO apuesta){
		
		Iterator<ApuestaVO> it = apuestasDelGranPremio.iterator();
		while(it.hasNext()) {
			ApuestaVO a = it.next();
			if(a.equals(apuesta)) {
				it.remove();
			}
			
		}
		
		return apuestasDelGranPremio;
	}

	public Set<ResultadoVO> getResultadosDelGranPremio() {
		return resultadosDelGranPremio;
	}

	public void setResultadosDelGranPremio(Set<ResultadoVO> resultadosDelGranPremio) {
		this.resultadosDelGranPremio = resultadosDelGranPremio;
	}
	
	public Set<ResultadoVO> addResultado (ResultadoVO resultado){
		
		this.resultadosDelGranPremio.add(resultado);
		return resultadosDelGranPremio;
	}


	public GranPremioVO getGp_anterior() {
		return gp_anterior;
	}


	public void setGp_anterior(GranPremioVO gp_anterior) {
		this.gp_anterior = gp_anterior;
	}
	
	
	
}
