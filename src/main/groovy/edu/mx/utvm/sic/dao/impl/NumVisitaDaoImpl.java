package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.NumVisitaDao;
import edu.mx.utvm.sic.dominio.NumVisita;
@Repository
public class NumVisitaDaoImpl extends JdbcTemplate implements NumVisitaDao {
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(NumVisita newInstance) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public NumVisita read(Integer id) {
		String sql= "SELECT * FROM num_visitas WHERE id_visita = ?";		
		NumVisita resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<NumVisita>(){

			@Override
			public NumVisita mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				NumVisita numVisita = new NumVisita();
				numVisita.setId(rs.getInt("id_visita"));					
				numVisita.setDescripcion(rs.getString("visita"));
				return numVisita;
			}
			
		});
		
		return resultado;
	}

	@Override
	public void update(NumVisita transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(NumVisita persistentObject) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public List<NumVisita> findAll() {
		String sql = "SELECT * FROM num_visitas";
		List<NumVisita> resultado = this.query(sql, new RowMapper<NumVisita>(){

			@Override
			public NumVisita mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				NumVisita numVisita = new NumVisita();
				numVisita.setId(rs.getInt("id_visita"));					
				numVisita.setDescripcion(rs.getString("visita"));
				return numVisita;
			}
			
		});
		
		return resultado;
	}	

}
