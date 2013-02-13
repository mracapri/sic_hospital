package edu.mx.utvm.sic.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.sic.dominio.Area;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-SpringMVC.xml")
@Transactional

public class TestAreaDao {
	@Autowired
	AreaDao areaDao;
	
	@Test
	public void testUnidadMedicaReadDao(){				
		
		Area read = areaDao.read(1);		
		boolean resultado = read.getDescripcion().equals("Rural");
		
		/*Test*/
		Assert.assertEquals(true, resultado);				
	}
	
	@Test
	public void testUnidadMedicaReturnAllDao(){								
		
		/*Get all*/
		List<Area> findAll = areaDao.findAll();
		 
		/*Test*/
		Assert.assertEquals(true, findAll.size() > 0);
	}
}
