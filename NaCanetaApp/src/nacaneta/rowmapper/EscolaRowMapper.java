package nacaneta.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nacaneta.model.Escola;

public class EscolaRowMapper implements RowMapper<Escola> {
	
	@Override
	public Escola mapRow(ResultSet rs, int rowNum) throws SQLException {
		Escola Escola = new Escola(
				rs.getString("nome")
				, rs.getString("endereco")
				, rs.getString("telefone"));
		
		
		Escola.setId(rs.getInt("id"));

		return Escola;
	}

}
