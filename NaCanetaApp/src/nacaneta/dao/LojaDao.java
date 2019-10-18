package nacaneta.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import nacaneta.model.Loja;

public class LojaDao implements DaoGenerico<Loja>{
	
private JdbcTemplate jdbcTemp;
	
	public LojaDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Loja> getAll() {
		List<Loja> list = jdbcTemp.query("select Id, Nome, Endereco,Telefone  from Loja", new RowMapper<Loja>() {

			@Override
			public Loja mapRow(ResultSet rs, int rowNum) throws SQLException {
				Loja loja = new Loja(
						rs.getInt("Id")
						, rs.getString("Nome")
						, rs.getString("Endereco")
						, rs.getString("Telefone"));

				return loja;
			}

		});
		
		
		return list;
	}

	@Override
	public void insert(String[] parameter) {
		
		//TO DO
		
	}

}
