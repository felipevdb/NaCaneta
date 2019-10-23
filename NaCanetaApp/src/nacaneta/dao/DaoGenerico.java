package nacaneta.dao;

import java.sql.SQLException;
import java.util.List;


public interface DaoGenerico<T> {
	
	public List<T> getAll();
	
	public void insert(String[] parameter) throws SQLException;
	

}
