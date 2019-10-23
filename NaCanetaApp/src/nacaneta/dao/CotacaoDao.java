package nacaneta.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import nacaneta.model.Cotacao;
import nacaneta.rowmapper.CotacaoRowMapper;


public class CotacaoDao implements DaoGenerico<Cotacao>{
	
	private JdbcTemplate jdbcTemp;
	
	public CotacaoDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Cotacao> getAll() {
		List<Cotacao> listaCotacao = jdbcTemp.query("CALL Mostrar_Cotacao_ALL()", new CotacaoRowMapper());
		
		return listaCotacao;
	}

	@Override
	public void insert(String[] parameter) {
		// TODO Auto-generated method stub
		
	}

}
