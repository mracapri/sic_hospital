package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.ServicioDao;
import edu.mx.utvm.sic.dominio.Servicio;
@Repository
public class ServicioDaoImpl extends JdbcTemplate implements ServicioDao {
	
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Servicio newInstance) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Servicio read(Integer id) {
		String sql= "SELECT * FROM servicio WHERE id_servicio = ?";
		
		Servicio resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<Servicio>(){

			@Override
			public Servicio mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Servicio servicio = new Servicio();
				servicio.setId(rs.getInt("id_servicio"));
				servicio.setDescripcion(rs.getString("servicio"));
				return servicio;
			}
			
		});
		
		return resultado;		
	}

	@Override
	public void update(Servicio transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(Servicio persistentObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public List<Servicio> findAll() {
		String sql = "SELECT * FROM servicio";
		List<Servicio> resultado = this.query(sql, new RowMapper<Servicio>(){

				@Override
				public Servicio mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Servicio servicio = new Servicio();
					servicio.setId(rs.getInt("id_servicio"));
					servicio.setDescripcion(rs.getString("servicio"));
					return servicio;
				}
				
			});
			
			return resultado;
	}

}
