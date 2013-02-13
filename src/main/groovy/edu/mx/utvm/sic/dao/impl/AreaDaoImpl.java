package edu.mx.utvm.sic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.sic.dao.AreaDao;
import edu.mx.utvm.sic.dominio.Area;

@Repository
public class AreaDaoImpl extends JdbcTemplate implements AreaDao{
	
	@Autowired	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Area newInstance) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Area read(Integer id) {
		String sql= "SELECT * FROM area WHERE id_area = ?";
		
		Area resultado = this.queryForObject(sql, new Object[]{ id }, new RowMapper<Area>(){

			@Override
			public Area mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Area area = new Area();
				area.setId(rs.getInt("id_area"));
				area.setDescripcion(rs.getString("area"));
				return area;
			}
			
		});
		
		return resultado;
	}

	@Override
	public void update(Area transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(Area persistentObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public List<Area> findAll() {
		String sql = "SELECT * FROM area";
		List<Area> resultado = this.query(sql, new RowMapper<Area>(){

				@Override
				public Area mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Area area = new Area();
					area.setId(rs.getInt("id_area"));
					area.setDescripcion(rs.getString("area"));
					return area;
				}
				
			});
			
			return resultado;

	}

}