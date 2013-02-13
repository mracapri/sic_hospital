package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.UnidadMedicaDao;
import edu.mx.utvm.sic.dominio.UnidadMedica;

@Repository
public class UnidadMedicaDaoImpl extends JdbcTemplate implements UnidadMedicaDao{
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(UnidadMedica newInstance) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public UnidadMedica read(Integer id) {
		String sql= "SELECT * FROM unidad_medica WHERE id_unidad_medica = ?";
		try {
			UnidadMedica resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<UnidadMedica>(){

				@Override
				public UnidadMedica mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					UnidadMedica unidadMedica = new UnidadMedica();
					unidadMedica.setId(rs.getInt("id_unidad_medica"));
					unidadMedica.setDescripcion(rs.getString("unidad_medica"));
					return unidadMedica;
				}
				
			});
			
			return resultado;
		} catch (Exception e) {
			return null;
		}		
	}

	@Override
	public void update(UnidadMedica transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(UnidadMedica persistentObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public List<UnidadMedica> findAll() {
		String sql = "SELECT * FROM unidad_medica";
		List<UnidadMedica> resultado = this.query(sql, new RowMapper<UnidadMedica>(){

			@Override
			public UnidadMedica mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				UnidadMedica unidadMedica = new UnidadMedica();
				unidadMedica.setId(rs.getInt("id_unidad_medica"));
				unidadMedica.setDescripcion(rs.getString("unidad_medica"));
				return unidadMedica;
			}
			
		});
		
		return resultado;		
	}
}
