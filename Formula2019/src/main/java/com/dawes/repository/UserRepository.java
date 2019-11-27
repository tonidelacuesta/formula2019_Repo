package com.dawes.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.modelo.ApuestaVO;
import com.dawes.modelo.UsuarioVO;

@Repository
@Transactional
public class UserRepository{

   @Autowired
   private EntityManager entityManager;
   
   
   public UsuarioVO findUserAccount(String userName) {
       try {
         

           Query query = entityManager.createQuery("select u from UsuarioVO u where u.userName=:nombre", UsuarioVO.class);
           query.setParameter("nombre", userName);

           return (UsuarioVO) query.getSingleResult();
       } catch (NoResultException e) {
           return null;
       }
   }
   
   @Modifying
   @Transactional
   public void cambiarContra(String encrited, String nombre) {
	   
	   try {
		  
		   Query query = entityManager.createQuery("update UsuarioVO u set u.encrytedPassword =:encrited where u.userName =:nombre");
		   query.setParameter("encrited",encrited);
		   query.setParameter("nombre",nombre);
		   query.executeUpdate();
		   
	   }catch(NoResultException e) {
		   
		   System.out.println("no se ha podido cambiar la contraseña");
		   
	   }
   }
   
   public void sumarPuntos(int puntos, Long id) {
	   
	   try {
			  
		   Query query = entityManager.createQuery("update UsuarioVO u set u.puntos =:puntos where u.userId =:id");
		   
		   query.setParameter("puntos",puntos);
		   query.setParameter("id",id);
		   query.executeUpdate();
		   
	   }catch(NoResultException e) {
		   
		   System.out.println("no se ha podido cambiar la contraseña");
		   
	   }
	   
	   
	   
   }
   
   public List<UsuarioVO> listarUsuarios() {
	   
	   List<UsuarioVO> listaUsuarios = new ArrayList<>();
	   
	   try {
			  
		   TypedQuery<UsuarioVO> query = entityManager.createQuery("select u from UsuarioVO u where u.userId > 2", UsuarioVO.class);
		   listaUsuarios = query.getResultList();  
		   
	   }catch(NoResultException e) {
		   
		   System.out.println("no se ha podido realizar la query");
		   
	   }
	   
	   
	   return listaUsuarios;
	   
	   
   }
   
  
}