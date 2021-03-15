package persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Order;
import persistence.ConnectionFactory;

public class OrderDao {

	public void create(Order order) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO orders(product, customer_id, amount) VALUES(?, ?, ?)");
		statement.setInt(1, order.getProductId());
		statement.setInt(2, order.getCustomerId());
		statement.setInt(3, order.getAmount());
		statement.executeUpdate();
		System.out.println("New order placed\n");
	}
	
	public List<Order> readAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders");
		ResultSet rs = statement.executeQuery();
		
		List<Order> orders= new ArrayList<>();
		while(rs.next()) {
			Order order = new Order();
			order.setId(rs.getInt("order_id"));
			order.setProductId(rs.getInt("product"));
			order.setCustomerId(rs.getInt("customer"));
			order.setAmount(rs.getInt("amount"));
			orders.add(order);
		}		
		return orders;
	}
	
	public Order read(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		
		Order order = null;
		
		while(rs.next()) {
			order = new Order();
			order.setId(rs.getInt("order_id"));
			order.setProductId(rs.getInt("product"));
			order.setCustomerId(rs.getInt("customer"));
			order.setAmount(rs.getInt("amount"));
			order.setOrderDate(rs.getString("order_date"));
			order.setRequiredDate(rs.getString("required_date"));
			order.setDeliveryDate(rs.getString("delivery_date"));
		}
		
		return order;
	}
	
	public void update(Order order) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE orders SET"
				+ "product = ?,"
				+ "customer = ?,"
				+ "amount = ?,"
				+ ")");
		statement.setInt(1, order.getProductId());
		statement.setInt(2, order.getCustomerId());
		statement.setInt(3, order.getAmount());
		statement.executeUpdate();

	}
	
	public void delete(Order order) throws SQLException {
		// TODO Auto-generated method stub

	}

}
