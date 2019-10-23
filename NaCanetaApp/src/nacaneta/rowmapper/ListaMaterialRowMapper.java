package nacaneta.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysql.jdbc.ResultSetMetaData;

import nacaneta.model.ListaMaterial;

public class ListaMaterialRowMapper implements RowMapper<ListaMaterial> {
	
		@Override
		public ListaMaterial mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			ListaMaterial listaMaterial = new ListaMaterial();
			
			ResultSetMetaData mt = (ResultSetMetaData) rs.getMetaData();
			
			for(int i=1; i<= mt.getColumnCount(); i++) {
				switch( mt.getColumnLabel(i) ) {
					case "serie_ListaMaterial" :
						listaMaterial.setSerie(rs.getString("serie_ListaMaterial"));
						break;
						
					case "ano_ListaMaterial" :
						listaMaterial.setAno(rs.getInt("ano_ListaMaterial"));
						break;
					
					case "id_ListaMaterial" :
						listaMaterial.setId(rs.getInt("id_ListaMaterial"));
						break;
						
					default:
						break;
				}
				
			}

			return listaMaterial;
		}

}
