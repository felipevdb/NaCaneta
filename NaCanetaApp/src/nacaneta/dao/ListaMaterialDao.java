package nacaneta.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import nacaneta.model.ListaMaterial;

public class ListaMaterialDao implements DaoGenerico<ListaMaterial> {
	
	private JdbcTemplate jdbcTemp;
	
	public ListaMaterialDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ListaMaterial> getAll() {
		List<ListaMaterial> list = jdbcTemp.query("select Id, Serie, Ano from ListaMaterial", new RowMapper<ListaMaterial>() {

			@Override
			public ListaMaterial mapRow(ResultSet rs, int rowNum) throws SQLException {
				ListaMaterial listaMaterial = new ListaMaterial(rs.getInt("id"), rs.getString("serie"), rs.getInt("ano"));

				return listaMaterial;
			}

		});
		
		
		return list;
	}

	@Override
	public void insert(String[] parameter) {
		
		//TO DO
		
	}
		
	
}
