package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.TurnoDao;
import edu.mx.utvm.sic.dominio.Turno;
@Repository
public class turnoDaoImpl extends JdbcTemplate implements TurnoDao{
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Turno newInstance) {
		throw new UnsupportedOperationException();	
		
	}

	@Override
	public Turno read(Integer id) {
		String sql= "SELECT * FROM turno WHERE id_turno = ?";
		
		Turno resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<Turno>(){

			@Override
			public Turno mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Turno turno = new Turno();
				turno.setId(rs.getInt("id_turno"));
				turno.setDescripcion(rs.getString("turno"));
				return turno;
			}
			
		});
		
		return resultado;		
		
	}

	@Override
	public void update(Turno transientObject) {
		throw new UnsupportedOperationException();	
		
	}

	@Override
	public void delete(Turno persistentObject) {
		throw new UnsupportedOperationException();	
		
	}

	@Override
	public List<Turno> findAll() {
		String sql = "SELECT * FROM turno";
		List<Turno> resultado = this.query(sql, new RowMapper<Turno>(){

				@Override
				public Turno mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Turno turno = new Turno();
					turno.setId(rs.getInt("id_turno"));
					turno.setDescripcion(rs.getString("turno"));
					return turno;
				}
				
			});
			
			return resultado;				
	}

}
