package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.PeriododDeRevisionDao;
import edu.mx.utvm.sic.dominio.PeriodoDeRevision;
@Repository
public class PeriodoDeRevisionDaoImpl extends JdbcTemplate implements PeriododDeRevisionDao{
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(PeriodoDeRevision newInstance) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public PeriodoDeRevision read(Integer id) {
		String sql= "SELECT * FROM periodo_revision WHERE id_periodo = ?";		
		PeriodoDeRevision resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<PeriodoDeRevision>(){

			@Override
			public PeriodoDeRevision mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				PeriodoDeRevision periodoDeRevision = new PeriodoDeRevision();
				periodoDeRevision.setId(rs.getInt("id_periodo"));				
				periodoDeRevision.setDescripcion(rs.getString("periodo"));
				return periodoDeRevision;
			}
			
		});
		
		return resultado;		

	}

	@Override
	public void update(PeriodoDeRevision transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(PeriodoDeRevision persistentObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public List<PeriodoDeRevision> findAll() {
		String sql = "SELECT * FROM periodo_revision";
		List<PeriodoDeRevision> resultado = this.query(sql, new RowMapper<PeriodoDeRevision>(){

			@Override
			public PeriodoDeRevision mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				PeriodoDeRevision periodo = new PeriodoDeRevision();
				periodo.setId(rs.getInt("id_periodo"));				
				periodo.setDescripcion(rs.getString("periodo"));
				return periodo;
			}
			
		});
		
		return resultado;
	}

}
