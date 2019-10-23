package nacaneta.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import nacaneta.model.Cotacao;
import nacaneta.model.ListaMaterial;
import nacaneta.rowmapper.CotacaoRowMapper;
import nacaneta.rowmapper.ListaMaterialRowMapper;

public class CotacaoDao implements DaoGenerico<Cotacao>{
	private JdbcTemplate jdbcTemp;
	
	public CotacaoDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Cotacao> getAll() {
		// TEST
		List<Cotacao> list = jdbcTemp.query("select id, valor from Cotacao", new CotacaoRowMapper());
		return list;
	}

	@Override
	public void insert(String[] parameter) {
		
		//TO DO
		
	}
}
