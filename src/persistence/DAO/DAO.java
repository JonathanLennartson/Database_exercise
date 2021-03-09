package persistence.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<O> {
	
	void create(O o) throws SQLException; 
	
	List<O> readAll() throws SQLException;
	
	O read(int id) throws SQLException;
	
	void update(O o) throws SQLException;
	
	void delete(O o) throws SQLException;
	
}
