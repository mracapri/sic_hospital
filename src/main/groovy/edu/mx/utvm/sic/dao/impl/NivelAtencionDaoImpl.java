package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.NivelAtencionDao;
import edu.mx.utvm.sic.dominio.NivelAtencion;

@Repository
public class NivelAtencionDaoImpl extends JdbcTemplate implements NivelAtencionDao {
	
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(NivelAtencion newInstance) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public NivelAtencion read(Integer id) {
		String sql= "SELECT * FROM nivel_atencion WHERE id_nivel = ?";		
		NivelAtencion resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<NivelAtencion>(){

			@Override
			public NivelAtencion mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				NivelAtencion nivelAtencion = new NivelAtencion();
				nivelAtencion.setId(rs.getInt("id_nivel"));					
				nivelAtencion.setDescripcion(rs.getString("nivel"));
				return nivelAtencion;
			}
			
		});
		
		return resultado;
	}

	@Override
	public void update(NivelAtencion transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(NivelAtencion persistentObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public List<NivelAtencion> findAll() {
		String sql = "SELECT * FROM nivel_atencion";
		List<NivelAtencion> resultado = this.query(sql, new RowMapper<NivelAtencion>(){

			@Override
			public NivelAtencion mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				NivelAtencion nivelAtencion = new NivelAtencion();
				nivelAtencion.setId(rs.getInt("id_nivel"));					
				nivelAtencion.setDescripcion(rs.getString("nivel"));
				return nivelAtencion;
			}
			
		});
		
		return resultado;
	}

}
