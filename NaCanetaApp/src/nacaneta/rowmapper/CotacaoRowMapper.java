package nacaneta.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nacaneta.model.Cotacao;

public class CotacaoRowMapper implements RowMapper<Cotacao> {

	@Override
	public Cotacao mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cotacao cotacao = new Cotacao(new EscolaRowMapper().mapRow(rs, rowNum), new ListaMaterialRowMapper().mapRow(rs, rowNum), new LojaRowMapper().mapRow(rs, rowNum), rs.getFloat("valor_Cotacao"));
		
		cotacao.setId(rs.getInt("id_Cotacao"));

		return cotacao;
	}

}
