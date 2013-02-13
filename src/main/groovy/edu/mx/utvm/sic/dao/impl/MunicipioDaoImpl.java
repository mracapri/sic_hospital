package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.MunicipioDao;
import edu.mx.utvm.sic.dominio.Municipio;

@Repository
public class MunicipioDaoImpl extends JdbcTemplate implements MunicipioDao {
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Municipio newInstance) {		
		throw new UnsupportedOperationException();	
	}

	@Override
	public Municipio read(Integer id) {
		String sql= "SELECT * FROM MUNICIPIO WHERE id_municipio = ?";
		try {
			Municipio resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<Municipio>(){

				@Override
				public Municipio mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Municipio municipio = new Municipio();
					municipio.setId(rs.getInt("id_municipio"));
					municipio.setIdEstado(rs.getInt("id_estado"));
					municipio.setDescripcion(rs.getString("municipio"));
					return municipio;
				}
				
			});
			
			return resultado;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void update(Municipio transientObject) {
		throw new UnsupportedOperationException();			
	}

	@Override
	public void delete(Municipio persistentObject) {		
		throw new UnsupportedOperationException();						
	}

	@Override
	public List<Municipio> findAll() {
		String sql = "SELECT * FROM MUNICIPIO";
		List<Municipio> resultado = this.query(sql, new RowMapper<Municipio>(){

			@Override
			public Municipio mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Municipio municipio = new Municipio();
				municipio.setId(rs.getInt("id_municipio"));
				municipio.setIdEstado(rs.getInt("id_estado"));
				municipio.setDescripcion(rs.getString("municipio"));
				return municipio;
			}
			
		});
		
		return resultado;
	}
}