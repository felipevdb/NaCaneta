package nacaneta.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import nacaneta.model.ListaMaterial;
import nacaneta.rowmapper.ListaMaterialRowMapper;

public class ListaMaterialDao implements DaoGenerico<ListaMaterial> {
	
	private JdbcTemplate jdbcTemp;
	
	public ListaMaterialDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ListaMaterial> getAll() {
		List<ListaMaterial> list = jdbcTemp.query("select Id, Serie, Ano from ListaMaterial", new ListaMaterialRowMapper());
		
		return list;
	}

	@Override
	public void insert(String[] parameter) {
		
		//TO DO
		
	}
	
}
