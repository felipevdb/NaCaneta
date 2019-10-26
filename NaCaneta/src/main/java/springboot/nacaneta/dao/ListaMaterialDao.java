package springboot.nacaneta.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.CallableStatement;

import springboot.nacaneta.model.ListaMaterial;
import springboot.nacaneta.rowmapper.ListaMaterialRowMapper;

public class ListaMaterialDao implements DaoGenerico<ListaMaterial> {

	private JdbcTemplate jdbcTemp;

	public ListaMaterialDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ListaMaterial> getAll() {
		List<ListaMaterial> list = jdbcTemp.query("CALL Mostrar_ListaMaterial_ALL()", new ListaMaterialRowMapper());

		return list;
	}

	@Override
	public void insert(String[] parameter) throws SQLException {

		if (parameter.length == 3) {

			int idEscola = Integer.parseInt(parameter[0]);
			String serie = parameter[1];
			int ano = Integer.parseInt(parameter[2]);

			String procedureQuery = "CALL Adicionar_ListaMaterial (?, ?, ?)";
			CallableStatement statement = (CallableStatement) jdbcTemp.getDataSource().getConnection()
					.prepareCall(procedureQuery);

			statement.setInt(1, idEscola);
			statement.setString(2, serie);
			statement.setInt(3, ano);

			statement.execute();
		}

	}

	public List<ListaMaterial> getByEscola(String parameter) throws SQLException {

		int idEscola = Integer.parseInt(parameter);
		
		List<ListaMaterial> list = jdbcTemp.query("CALL Mostrar_ListaMaterial_POR_Escola ("+idEscola+")", new ListaMaterialRowMapper());

		return list;
	}

}
