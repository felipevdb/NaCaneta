package nacaneta.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import nacaneta.model.Loja;
import nacaneta.rowmapper.LojaRowMapper;

public class LojaDao implements DaoGenerico<Loja>{
	
private JdbcTemplate jdbcTemp;
	
	public LojaDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Loja> getAll() {
		List<Loja> listaLoja = jdbcTemp.query("select Id, Nome, Endereco,Telefone  from Loja", new LojaRowMapper());
		
		return listaLoja;
	}

	@Override
	public void insert(String[] parameter) {
		
		//TO DO
		
	}

}
