package com.dawes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="apuestas")
public class ApuestaVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idapuesta;
	
    @ManyToOne
    @JoinColumn(name="apuestasDelGranPremio")
	private GranPremioVO carrera;
	
    @ManyToOne
    @JoinColumn(name="apuestasDelJugador")
	private UsuarioVO jugador;
	
	private String piloto1;
	
	private String piloto2;
	
	private String piloto3;
	
	private String VRapida;
	
	private int acierto_primero;
	
	private int acierto_segundo;
	
	private int acierto_tercero;
	
	private int acierto_vrapida;

	public ApuestaVO(int idapuesta, GranPremioVO carrera, UsuarioVO jugador, String piloto1, String piloto2,
			String piloto3, String vRapida) {
		super();
		this.idapuesta = idapuesta;
		this.carrera = carrera;
		this.jugador = jugador;
		this.piloto1 = piloto1;
		this.piloto2 = piloto2;
		this.piloto3 = piloto3;
		VRapida = vRapida;
	}

	public ApuestaVO(GranPremioVO carrera, UsuarioVO jugador, String piloto1, String piloto2, String piloto3,
			String vRapida) {
		super();
		this.carrera = carrera;
		this.jugador = jugador;
		this.piloto1 = piloto1;
		this.piloto2 = piloto2;
		this.piloto3 = piloto3;
		VRapida = vRapida;
	}

	public ApuestaVO() {
		super();
	}

	public int getIdapuesta() {
		return idapuesta;
	}

	public void setIdapuesta(int idapuesta) {
		this.idapuesta = idapuesta;
	}

	public GranPremioVO getCarrera() {
		return carrera;
	}

	public void setCarrera(GranPremioVO carrera) {
		this.carrera = carrera;
	}

	public UsuarioVO getJugador() {
		return jugador;
	}

	public void setJugador(UsuarioVO jugador) {
		this.jugador = jugador;
	}

	public String getPiloto1() {
		return piloto1;
	}

	public void setPiloto1(String piloto1) {
		this.piloto1 = piloto1;
	}

	public String getPiloto2() {
		return piloto2;
	}

	public void setPiloto2(String piloto2) {
		this.piloto2 = piloto2;
	}

	public String getPiloto3() {
		return piloto3;
	}

	public void setPiloto3(String piloto3) {
		this.piloto3 = piloto3;
	}

	public String getVRapida() {
		return VRapida;
	}

	public void setVRapida(String vRapida) {
		VRapida = vRapida;
	}

	public int getAcierto_primero() {
		return acierto_primero;
	}

	public void setAcierto_primero(int acierto_primero) {
		this.acierto_primero = acierto_primero;
	}

	public int getAcierto_segundo() {
		return acierto_segundo;
	}

	public void setAcierto_segundo(int acierto_segundo) {
		this.acierto_segundo = acierto_segundo;
	}

	public int getAcierto_tercero() {
		return acierto_tercero;
	}

	public void setAcierto_tercero(int acierto_tercero) {
		this.acierto_tercero = acierto_tercero;
	}

	public int getAcierto_vrapida() {
		return acierto_vrapida;
	}

	public void setAcierto_vrapida(int acierto_vrapida) {
		this.acierto_vrapida = acierto_vrapida;
	}
	
	
	
	
	
}
