package nacaneta.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nacaneta.model.ListaMaterial;

public class ListaMaterialRowMapper implements RowMapper<ListaMaterial> {
	
		@Override
		public ListaMaterial mapRow(ResultSet rs, int rowNum) throws SQLException {
			ListaMaterial listaMaterial = new ListaMaterial(rs.getString("serie"), rs.getInt("ano"));
			listaMaterial.setId(rs.getInt("id"));

			return listaMaterial;
		}

}
