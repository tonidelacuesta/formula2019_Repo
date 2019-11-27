
package com.dawes.modelo;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "usuarios", //
       uniqueConstraints = { //
               @UniqueConstraint(name = "USUARIOS_UK", columnNames = "User_Name") })
public class UsuarioVO {

   @Id
   @GeneratedValue
   @Column(name = "User_Id", nullable = false)
   private Long userId;

   @Column(name = "User_Name", length = 36, nullable = false)
   private String userName;

   @Column(name = "Encryted_Password", length = 128, nullable = false)
   private String encrytedPassword;

   @Column(name = "Enabled", length = 1, nullable = false)
   private boolean enabled;
   
   @OneToMany(mappedBy="usuario",fetch=FetchType.EAGER, cascade= {CascadeType.ALL}, orphanRemoval = true)
   private Set<UsuarioRolVO> roles = new HashSet<UsuarioRolVO>();
   
   @OneToMany(mappedBy="jugador",fetch=FetchType.LAZY, cascade= {CascadeType.ALL}, orphanRemoval = true)
   private Set<ApuestaVO> apuestasDelJugador = new HashSet<ApuestaVO>();
   
   @Column(name = "puntos")
   private int puntos;
   
   public int getPuntos() {
	return puntos;
   }

   public void setPuntos(int puntos) {
	this.puntos = puntos;
   }

   public Long getUserId() {
       return userId;
   }

   public void setUserId(Long userId) {
       this.userId = userId;
   }

   public String getUserName() {
       return userName;
   }

   public void setUserName(String userName) {
       this.userName = userName;
   }

   public String getEncrytedPassword() {
       return encrytedPassword;
   }

   public void setEncrytedPassword(String encrytedPassword) {
       this.encrytedPassword = encrytedPassword;
   }

   public boolean isEnabled() {
       return enabled;
   }

   public void setEnabled(boolean enabled) {
       this.enabled = enabled;
   }

public Set<UsuarioRolVO> getRoles() {
	return roles;
}

public void setRoles(Set<UsuarioRolVO> roles) {
	this.roles = roles;
}

public Set<ApuestaVO> getApuestasDelJugador() {
	return apuestasDelJugador;
}

public void setApuestasDelJugador(Set<ApuestaVO> apuestasDelJugador) {
	this.apuestasDelJugador = apuestasDelJugador;
}

public Set<ApuestaVO> addApuestaDelJugador (ApuestaVO a) {
	
	this.apuestasDelJugador.add(a);
	return apuestasDelJugador;
}

public Set<ApuestaVO> removeApuestaDelJugador(ApuestaVO a){
	
	Iterator<ApuestaVO> it = apuestasDelJugador.iterator();
	
	while(it.hasNext()) {
		
		ApuestaVO x = it.next();
		
			if(x.equals(a)) {
				it.remove();
		}
		
	}
	return apuestasDelJugador;
}

}