package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="resultados")
public class ResultadoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idresultado;
	
	private String piloto1;
	
	private String piloto2;
	
	private String piloto3;
	
	private String vrapida;
	
	private LocalDate fecha;
	
	@ManyToOne
    @JoinColumn(name="resultadosDelGranPremio")
	private GranPremioVO gp;

	public ResultadoVO(int idresultado, String piloto1, String piloto2, String piloto3, String vrapida, LocalDate fecha,
			GranPremioVO gp) {
		super();
		this.idresultado = idresultado;
		this.piloto1 = piloto1;
		this.piloto2 = piloto2;
		this.piloto3 = piloto3;
		this.vrapida = vrapida;
		this.fecha = fecha;
		this.gp = gp;
	}

	public ResultadoVO(String piloto1, String piloto2, String piloto3, String vrapida, LocalDate fecha,
			GranPremioVO gp) {
		super();
		this.piloto1 = piloto1;
		this.piloto2 = piloto2;
		this.piloto3 = piloto3;
		this.vrapida = vrapida;
		this.fecha = fecha;
		this.gp = gp;
	}

	public ResultadoVO(String piloto1, String piloto2, String piloto3, String vrapida, LocalDate fecha) {
		super();
		this.piloto1 = piloto1;
		this.piloto2 = piloto2;
		this.piloto3 = piloto3;
		this.vrapida = vrapida;
		this.fecha = fecha;
	}

	public ResultadoVO() {
		super();
	}

	public int getIdresultado() {
		return idresultado;
	}

	public void setIdresultado(int idresultado) {
		this.idresultado = idresultado;
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

	public String getVrapida() {
		return vrapida;
	}

	public void setVrapida(String vrapida) {
		this.vrapida = vrapida;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public GranPremioVO getGp() {
		return gp;
	}

	public void setGp(GranPremioVO gp) {
		this.gp = gp;
	}
	
	
	

}
