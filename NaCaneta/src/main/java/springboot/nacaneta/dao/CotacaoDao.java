package springboot.nacaneta.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.CallableStatement;

import springboot.nacaneta.model.Cotacao;
import springboot.nacaneta.rowmapper.CotacaoRowMapper;


public class CotacaoDao implements DaoGenerico<Cotacao>{
	
	private JdbcTemplate jdbcTemp;
	
	public CotacaoDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Cotacao> getAll() {
		List<Cotacao> listaCotacao = jdbcTemp.query("CALL Mostrar_Cotacao_ALL()", new CotacaoRowMapper());
		
		return listaCotacao;
	}
	

	@Override
	public void insert(String[] parameter) throws SQLException {
		
		if (parameter.length == 3) {
			float valor = Float.parseFloat(parameter[0]);
			int idListaMaterial = Integer.parseInt(parameter[1]);
			int idLoja = Integer.parseInt(parameter[2]);
		
			String procedureQuery = "CALL Adicionar_Cotacao (?, ?, ?)";
			CallableStatement  statement = (CallableStatement ) jdbcTemp.getDataSource().getConnection().prepareCall(procedureQuery);
			
			statement.setFloat(1, valor);
			statement.setInt(2, idListaMaterial);
			statement.setInt(3, idLoja);
		
			statement.execute();
		}
		
	}

}
