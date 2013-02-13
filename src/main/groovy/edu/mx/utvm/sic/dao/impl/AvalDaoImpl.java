package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.AvalDao;
import edu.mx.utvm.sic.dominio.Aval;
@Repository
public class AvalDaoImpl extends JdbcTemplate implements AvalDao {
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Aval newInstance) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public Aval read(Integer id) {
		String sql= "SELECT * FROM aval WHERE id_aval = ?";
		
		Aval resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<Aval>(){

			@Override
			public Aval mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Aval aval = new Aval();
				aval.setId(rs.getInt("id_aval"));
				aval.setDescripcion(rs.getString("aval"));
				return aval;
			}
			
		});
		
		return resultado;
	}

	@Override
	public void update(Aval transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(Aval persistentObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public List<Aval> findAll() {
		String sql = "SELECT * FROM aval";
		List<Aval> resultado = this.query(sql, new RowMapper<Aval>(){

				@Override
				public Aval mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Aval aval = new Aval();
					aval.setId(rs.getInt("id_aval"));
					aval.setDescripcion(rs.getString("aval"));
					return aval;
				}
				
			});
			
			return resultado;
	}

}
