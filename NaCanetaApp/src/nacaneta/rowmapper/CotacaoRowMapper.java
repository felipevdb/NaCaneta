package nacaneta.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nacaneta.model.Cotacao;
import nacaneta.model.ListaMaterial;

public class CotacaoRowMapper implements RowMapper<Cotacao> {

	@Override
	public Cotacao mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TEST
		Cotacao cotacao = new Cotacao(rs.getInt("id"));

		return cotacao;
	}

}
