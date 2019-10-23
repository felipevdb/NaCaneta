package nacaneta.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysql.jdbc.ResultSetMetaData;

import nacaneta.model.Escola;

public class EscolaRowMapper implements RowMapper<Escola> {
	
	@Override
	public Escola mapRow(ResultSet rs, int rowNum) throws SQLException {
		Escola Escola = new Escola();

		ResultSetMetaData mt = (ResultSetMetaData) rs.getMetaData();
		
		for(int i=1; i<= mt.getColumnCount(); i++) {
			switch( mt.getColumnLabel(i) ) {
				case "nome_Escola" :
					Escola.setNome(rs.getString("nome_Escola"));
					break;
					
				case "endereco_Escola" :
					Escola.setEndereco(rs.getString("endereco_Escola"));
					break;
				
				case "telefone_Escola" :
					Escola.setTelefone(rs.getString("telefone_Escola"));
					break;
					
				case "id_Escola" :
					Escola.setId(rs.getInt("id_Escola"));
					break;
					
				default:
					break;
			}
			
		}

		return Escola;
	}

}
