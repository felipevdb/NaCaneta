package springboot.nacaneta.dao;


import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.CallableStatement;

import springboot.nacaneta.model.Loja;
import springboot.nacaneta.rowmapper.LojaRowMapper;

public class LojaDao implements DaoGenerico<Loja>{
	
private JdbcTemplate jdbcTemp;
	
	public LojaDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Loja> getAll() {
		List<Loja> listaLoja = jdbcTemp.query("CALL Mostrar_Loja()", new LojaRowMapper());
		
		return listaLoja;
	}

	@Override
	public void insert(String[] parameter) throws SQLException {
		
		if (parameter.length == 3) {
			
			String Nome = parameter[0];
			String Endereco = parameter[2];
			String Telefone = parameter[3];
		
			String procedureQuery = "CALL Adicionar_Loja(?, ?, ?)";
			CallableStatement  statement = (CallableStatement ) jdbcTemp.getDataSource().getConnection().prepareCall(procedureQuery);
			
			statement.setString(1, Nome);
			statement.setString(2, Endereco);
			statement.setString(3, Telefone);
		
			statement.execute();
		}
		
	}

}
