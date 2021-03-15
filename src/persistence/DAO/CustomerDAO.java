package persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Customer;
import persistence.ConnectionFactory;

public class CustomerDAO implements DAO<Customer>{

	@Override
	public void create(Customer c) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO customers(name, email, adress, commentary, organisation, discount_group) VALUES(?, ?, ?, ?, ?, ?)");
		statement.setString(1, c.getName());
		statement.setString(2, c.getEmail());
		statement.setString(3, c.getAdress());
		statement.setString(4, c.getCommentary());
		statement.setString(5, c.getOrganisation());
		statement.setInt(6, c.getDiscountGroup());
		statement.executeUpdate();
		System.out.println("New customer, " + c.getName() + ", added to database");
		
	}

	@Override
	public List<Customer> readAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers");
		ResultSet rs = statement.executeQuery();
		
		List<Customer> customers = new ArrayList<>();
		while (rs.next()) {
			Customer c = new Customer();
			c.setId(rs.getInt("customer_id"));
			c.setName(rs.getString("name"));
			c.setEmail(rs.getString("email"));
			c.setAdress(rs.getString("adress"));
			c.setCommentary(rs.getString("commentary"));
			c.setOrganisation(rs.getString("organisation"));
			c.setDiscountGroup(rs.getInt("discount_group"));
			customers.add(c);
		}
		
		return customers;
	}

	@Override
	public Customer read(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE customer_id = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		
		Customer c = null;
		if(rs.next()) {
			c = new Customer();
			c.setId(rs.getInt("customer_id"));
			c.setName(rs.getString("name"));
			c.setEmail(rs.getString("email"));
			c.setAdress(rs.getString("adress"));
			c.setCommentary(rs.getString("commentary"));
			c.setOrganisation(rs.getString("organisation"));
			c.setDiscountGroup(rs.getInt("discount_group"));			
		}
		
		return c;
	}

	@Override
	public void update(Customer c) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE customers SET name = ?, email = ?, adress = ?, commentary = ?, organisation = ?, discount_group = ? WHERE customer_id = ?");
		statement.setString(1, c.getName());
		statement.setString(2, c.getEmail());
		statement.setString(3, c.getAdress());
		statement.setString(4, c.getCommentary());
		statement.setString(5, c.getOrganisation());
		statement.setInt(6, c.getDiscountGroup());
		statement.setInt(7, c.getId());
		statement.executeUpdate();
		System.out.println("Customer, " + c.getName() + ", updated in database");
		
	}

	@Override
	public void delete(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM customers WHERE customer_id = ?");
		statement.setInt(1, id);
		statement.executeUpdate();
		
		System.out.println("Kund borttagen ur databasen\n");
	}

}
