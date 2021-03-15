package persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Employee;
import persistence.ConnectionFactory;

public class EmployeeDAO implements DAO<Employee> {

	@Override
	public void create(Employee o) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO employees(name, email, adress, commentary, office_id) VALUES(?, ?, ?, ?, ?)");
		statement.setString(1, o.getName());
		statement.setString(2, o.getEmail());
		statement.setString(3, o.getAdress());
		statement.setString(4, o.getCommentary());
		statement.setInt(5, o.getOfficeId());
		statement.executeUpdate();
		System.out.println("New employee, " + o.getName() + ", added to database");
		
	}

	@Override
	public List<Employee> readAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees");
		ResultSet rs = statement.executeQuery();
		
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt("employee_id"));
			e.setName(rs.getString("name"));
			e.setEmail(rs.getString("email"));
			e.setAdress(rs.getString("adress"));
			e.setCommentary(rs.getString("commentary"));
			e.setOfficeId(rs.getInt("office_id"));
			employees.add(e);
		}
		
		return employees;
	}

	@Override
	public Employee read(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		
		Employee e = null;
		if(rs.next()) {
			e = new Employee();
			e.setId(rs.getInt("employee_id"));
			e.setName(rs.getString("name"));
			e.setEmail(rs.getString("email"));
			e.setAdress(rs.getString("adress"));
			e.setCommentary(rs.getString("commentary"));
			e.setOfficeId(rs.getInt("office_id"));			
		}
		
		return e;
	}

	@Override
	public void update(Employee e) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE employees SET name = ?, email = ?, adress = ?, commentary = ?, office_id = ? WHERE employee_id = ?");
		statement.setString(1, e.getName());
		statement.setString(2, e.getEmail());
		statement.setString(3, e.getAdress());
		statement.setString(4, e.getCommentary());
		statement.setInt(5, e.getOfficeId());
		statement.setInt(6, e.getId());
		statement.executeUpdate();
		
	}

	@Override
	public void delete(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM employees WHERE employee_id = ?");
		statement.setInt(1, id);
		statement.executeUpdate();
		
		System.out.println("Anställd borttagen ur databasen\n");
		
	}

}
