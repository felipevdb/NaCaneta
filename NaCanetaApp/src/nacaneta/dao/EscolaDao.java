package nacaneta.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.CallableStatement;

import nacaneta.model.Escola;
import nacaneta.rowmapper.EscolaRowMapper;

public class EscolaDao implements DaoGenerico<Escola> {
	
	private JdbcTemplate jdbcTemp;
	
	public EscolaDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Escola> getAll() {
		
		List<Escola> list = jdbcTemp.query("CALL Mostrar_Escola()", new EscolaRowMapper());
		
		return list;
	}

	@Override
	public void insert(String[] parameter) throws SQLException {
			
		if (parameter.length == 3) {
			
			String Nome = parameter[0];
			String Endereco = parameter[2];
			String Telefone = parameter[3];
		
			String procedureQuery = "CALL Adicionar_Escola(?, ?, ?)";
			CallableStatement  statement = (CallableStatement ) jdbcTemp.getDataSource().getConnection().prepareCall(procedureQuery);
			
			statement.setString(1, Nome);
			statement.setString(2, Endereco);
			statement.setString(3, Telefone);
		
			statement.execute();
		}
		
	}
	
}