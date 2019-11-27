package com.dawes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuariorol", //
       uniqueConstraints = { //
               @UniqueConstraint(name = "USUARIO_ROL_UK", columnNames = { "User_Id", "Role_Id" }) })
public class UsuarioRolVO {

   @Id
   @GeneratedValue
   @Column(name = "Id", nullable = false)
   private Long id;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "User_Id", nullable = false)
   private UsuarioVO usuario;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "Role_Id", nullable = false)
   private RolVO rol;

   public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public UsuarioVO getUsuario() {
       return usuario;
   }

   public void setUsuario(UsuarioVO usuario) {
       this.usuario = usuario;
   }

   public RolVO getRol() {
       return rol;
   }

   public void setRol(RolVO rol) {
       this.rol = rol;
   }
    
}