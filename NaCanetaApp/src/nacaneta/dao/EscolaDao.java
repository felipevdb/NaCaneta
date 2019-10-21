package nacaneta.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import nacaneta.model.Escola;
import nacaneta.rowmapper.EscolaRowMapper;

public class EscolaDao implements DaoGenerico<Escola> {
	
	private JdbcTemplate jdbcTemp;
	
	public EscolaDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Escola> getAll() {
		List<Escola> list = jdbcTemp.query("SELECT Id, Nome, Endereco, Telefone FROM Escola", new EscolaRowMapper());
		
		return list;
	}

	@Override
	public void insert(String[] parameter) {
		
		//TO DO
		
	}
	
}