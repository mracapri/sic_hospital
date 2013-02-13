package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.LocalidadDao;
import edu.mx.utvm.sic.dominio.Localidad;

@Repository
public class LocalidadDaoImpl extends JdbcTemplate implements LocalidadDao {			
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Localidad newInstance) {		
		throw new UnsupportedOperationException();
	}

	@Override
	public Localidad read(Integer id) {
		String sql = "SELECT * FROM localidad WHERE id_localidad=?";
		Localidad resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<Localidad>(){

			@Override
			public Localidad mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Localidad localidad = new Localidad();
				localidad.setId(rs.getInt("id_localidad"));				
				localidad.setIdMunicipio(rs.getInt("id_municipio"));
				localidad.setClave(rs.getString("clave"));
				localidad.setDescripcion(rs.getString("localidad"));
				localidad.setLatitud(rs.getString("latitud"));
				localidad.setLongitud(rs.getString("longitud"));
				localidad.setAltitud(rs.getString("altitud"));
				return localidad;
			}
			
		});
		
		return resultado;		
		
	}

	@Override
	public void update(Localidad transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(Localidad persistentObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public List<Localidad> findAll() {
		String sql = "SELECT * FROM localidad";
		List<Localidad> resultado = this.query(sql, new RowMapper<Localidad>(){

			@Override
			public Localidad mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Localidad localidad = new Localidad();
				localidad.setId(rs.getInt("id_localidad"));				
				localidad.setIdMunicipio(rs.getInt("id_municipio"));
				localidad.setClave(rs.getString("clave"));
				localidad.setDescripcion(rs.getString("localidad"));
				localidad.setLatitud(rs.getString("latitud"));
				localidad.setLongitud(rs.getString("longitud"));
				localidad.setAltitud(rs.getString("altitud"));
				return localidad;
			}
			
		});
		
		return resultado;
	}

}
