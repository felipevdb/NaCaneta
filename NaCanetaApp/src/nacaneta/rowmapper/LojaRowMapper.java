package nacaneta.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nacaneta.model.Loja;

public class LojaRowMapper implements RowMapper<Loja> {
	
	@Override
	public Loja mapRow(ResultSet rs, int rowNum) throws SQLException {
		Loja Loja = new Loja(
				rs.getString("nome")
				, rs.getString("endereco")
				, rs.getString("telefone"));
		
		
		Loja.setId(rs.getInt("id"));

		return Loja;
	}

}
