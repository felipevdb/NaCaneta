package nacaneta.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysql.jdbc.ResultSetMetaData;

import nacaneta.model.Loja;

public class LojaRowMapper implements RowMapper<Loja> {
	
	@Override
	public Loja mapRow(ResultSet rs, int rowNum) throws SQLException {
		Loja loja = new Loja();
		
		ResultSetMetaData mt = (ResultSetMetaData) rs.getMetaData();
		
		for(int i=1; i<= mt.getColumnCount(); i++) {
			switch( mt.getColumnLabel(i) ) {
				case "nome_Loja" :
					loja.setNome(rs.getString("nome_Loja"));
					break;
					
				case "endereco_Loja" :
					loja.setEndereco(rs.getString("endereco_Loja"));
					break;
				
				case "telefone_Loja" :
					loja.setTelefone(rs.getString("telefone_Loja"));
					break;
					
				case "id_Loja" :
					loja.setId(rs.getInt("id_Loja"));
					break;	
				
				default:
					break;
			}
			
		}

		
		return loja;
	}

}
