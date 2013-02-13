package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.InstitucionDao;
import edu.mx.utvm.sic.dominio.Institucion;

@Repository
public class InstitucionDaoImpl extends JdbcTemplate implements InstitucionDao{
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(Institucion newInstance) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Institucion read(Integer id) {
		String sql = "SELECT * FROM institucion WHERE id_institucion=?";
		try {
			Institucion resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<Institucion>(){

				@Override
				public Institucion mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Institucion institucion = new Institucion();
					institucion.setId(rs.getInt("id_institucion"));
					institucion.setId_estado(rs.getInt("id_estado"));
					institucion.setId_municipio(rs.getInt("id_municipio"));
					institucion.setDescripcion(rs.getString("institucion"));
					return institucion;
				}
				
			});
			
			return resultado;
		} catch (Exception e) {
			return null;
		}		
	}

	@Override
	public void update(Institucion transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(Institucion persistentObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public List<Institucion> findAll() {
		String sql = "SELECT * FROM institucion";
		List<Institucion> resultado = this.query(sql, new RowMapper<Institucion>(){

			@Override
			public Institucion mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Institucion institucion = new Institucion();
				institucion.setId(rs.getInt("id_institucion"));
				institucion.setId_estado(rs.getInt("id_estado"));
				institucion.setId_municipio(rs.getInt("id_municipio"));
				institucion.setDescripcion(rs.getString("institucion"));
				return institucion;
			}
			
		});
		
		return resultado;		
	}
	
}
