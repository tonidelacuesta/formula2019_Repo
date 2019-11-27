package com.dawes;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dawes.modelo.GranPremioVO;
import com.dawes.repository.GranPremioRepository;
import com.dawes.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApuestasF1ApplicationTests {
	
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	GranPremioRepository gpr;
	
	@Test
	public void M1AddGranPremio() {
		
		GranPremioVO gp = new GranPremioVO("Albacete", LocalDate.now(), null, null,null);
		gpr.save(gp);
		
		assertEquals("Albacete", gp.getCiudad());
	
	}
	

		
}