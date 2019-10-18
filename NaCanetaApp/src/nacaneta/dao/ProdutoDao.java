package nacaneta.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import nacaneta.model.Produto;

public class ProdutoDao implements DaoGenerico<Produto> {
	
	private JdbcTemplate jdbcTemp;
	
	public ProdutoDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Produto> getAll() {
		List<Produto> list = jdbcTemp.query("select Id, Descricao, Marca,Preco  from Produto", new RowMapper<Produto>() {

			@Override
			public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Produto produto = new Produto(
						rs.getInt("Id")
						, rs.getString("Descricao")
						, rs.getString("Marca")
						, rs.getFloat("Preco"));

				return produto;
			}

		});
		
		
		return list;
	}

	@Override
	public void insert(String[] parameter) {
		
		if (parameter.length == 2) {		
			
			jdbcTemp.batchUpdate("call Inserir_Item(?, ?)", parameter[1] , parameter[2]);
		}
		
	}
		
	
}
