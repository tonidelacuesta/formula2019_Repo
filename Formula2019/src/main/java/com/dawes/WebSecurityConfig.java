package com.dawes;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dawes.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	    @Autowired
	    private UserDetailsServiceImpl userDetailsService;
	 
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	 
	    // En el método configureGlobal es donde se lee la información del usuario en la base de datos
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	 
	        // Buscamos el usuario a traves del servicio y se encripta la password introducida en el login
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	 
	    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	
    	   http.csrf().disable();
    	   
           // Estas páginas no necesitan login
           http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
           
           //para que no de problemas security con h2
           http.headers().frameOptions().disable();
           
           // Recursos en directorios protegidos y roles que pueden acceder
           // Si no se loguean correctamente se redirige a /login
           http.authorizeRequests().antMatchers("/registrado").access("hasAnyRole('USER', 'ADMIN')");
    
           // Recursos protegidos para el rol admin
           http.authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')");
    
           // Usuario no autorizado: está registrado en base de datos pero sin permisos para el recurso
           // al que intenta acceder
           http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
    
           // Configuramos la página de login
           http.authorizeRequests().and().formLogin()//
                   .loginProcessingUrl("/j_spring_security_check") // Submit URL
                   .loginPage("/login")//
                   .failureUrl("/login?error=true")//
                   .usernameParameter("username")//
                   .passwordParameter("password");
               
    }

   
}