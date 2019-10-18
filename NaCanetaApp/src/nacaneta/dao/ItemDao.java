package nacaneta.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import nacaneta.model.Item;

public class ItemDao implements DaoGenerico<Item>  {
	
	private JdbcTemplate jdbcTemp;
	
	public ItemDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Item> getAll() {
		List<Item> list = jdbcTemp.query("select Id, Descricao, Quantidade from Item", new RowMapper<Item>() {

			@Override
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				Item item = new Item(
						rs.getInt("Id")
						, rs.getString("Descricao")
						, rs.getInt("Quantidade"));

				return item;
			}

		});
		
		
		return list;
	}

	@Override
	public void insert(String[] parameter) {
		
		//TO DO
		
	}
}
