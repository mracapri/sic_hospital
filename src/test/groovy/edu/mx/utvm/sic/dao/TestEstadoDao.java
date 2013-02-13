package edu.mx.utvm.sic.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.sic.dominio.Estado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-SpringMVC.xml")
@Transactional
public class TestEstadoDao {
	@Autowired
	EstadoDao estadoDao;
		
	@Test
	public void testEstadoReadDao(){													
				
		Estado read = estadoDao.read(1);	
		boolean resultado = read.getDescripcion().equals("HIDALGO");
		
		/*Test*/
		Assert.assertEquals(true, resultado);				
	}
	
	@Test
	public void testEstadoReturnAllDao(){				
		
		/*Get all estados*/
		List<Estado> findAll = estadoDao.findAll();
		 
		/*Test*/
		Assert.assertEquals(true, findAll.size() > 0);
	}
		
}