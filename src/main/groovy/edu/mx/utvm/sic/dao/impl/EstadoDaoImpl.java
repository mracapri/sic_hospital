package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.EstadoDao;
import edu.mx.utvm.sic.dominio.Estado;

@Repository
public class EstadoDaoImpl extends JdbcTemplate implements EstadoDao{
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Estado newInstance) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public Estado read(Integer id) {
		String sql= "SELECT * FROM ESTADO WHERE id_estado = ?";
		try {
			Estado resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<Estado>(){

				@Override
				public Estado mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Estado estado = new Estado();
					estado.setId(rs.getInt("id_estado"));
					estado.setDescripcion(rs.getString("estado"));
					return estado;
				}
				
			});
			
			return resultado;
		} catch (Exception e) {
			return null;
		}
			
	}

	@Override
	public void update(Estado transientObject) {
		throw new UnsupportedOperationException();			
	}

	@Override
	public void delete(Estado persistentObject) {				
		throw new UnsupportedOperationException();					
	}

	@Override
	public List<Estado> findAll() {
		String sql = "SELECT * FROM ESTADO";
		List<Estado> resultado = this.query(sql, new RowMapper<Estado>(){

			@Override
			public Estado mapRow(ResultSet rs, int rowNum) throws SQLException {
				Estado estado = new Estado();
				estado.setId(rs.getInt("id_estado"));
				estado.setDescripcion(rs.getString("estado"));
				return estado;
			}
			
		});
		return resultado;
	}	

}
