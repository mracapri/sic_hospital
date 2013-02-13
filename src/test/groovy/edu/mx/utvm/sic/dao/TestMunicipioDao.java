package edu.mx.utvm.sic.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.sic.dominio.Municipio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-SpringMVC.xml")
@Transactional
public class TestMunicipioDao {
	@Autowired
	MunicipioDao municipioDao;				
	
	@Test
	public void testMunicipioReadDao(){				
										
		Municipio read = municipioDao.read(1);		
		boolean resultado = read.getDescripcion().equals("IXMIQUILPAN");
		
		/*Test*/
		Assert.assertEquals(true, resultado);				
	}
	
	@Test
	public void testMunicipioReturnAllDao(){								
		
		/*Get all municipios*/
		List<Municipio> findAll = municipioDao.findAll();
		 
		/*Test*/
		Assert.assertEquals(true, findAll.size() > 0);
	}		
}
