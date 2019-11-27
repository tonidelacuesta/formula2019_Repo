package com.dawes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pilotos")
public class PilotoVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpiloto;
	
	private String nombre;
	
	private int puntos;
	

	public PilotoVO(int idpiloto, String nombre, int puntos) {
		super();
		this.idpiloto = idpiloto;
		this.nombre = nombre;
		this.puntos = puntos;
	}
	
	

	public PilotoVO(String nombre, int puntos) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
	}

	

	public PilotoVO() {
		super();
	}



	public int getIdpiloto() {
		return idpiloto;
	}

	public void setIdpiloto(int idpiloto) {
		this.idpiloto = idpiloto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
	
}
