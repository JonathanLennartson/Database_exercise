package persistence.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Order;
import persistence.ConnectionFactory;

public class OrderDAO {

	public void create(Order order) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO orders(product_id, customer_id, amount, required_date, delivery_date) VALUES(?, ?, ?, ?, ?)");
		statement.setInt(1, order.getProductId());
		statement.setInt(2, order.getCustomerId());
		statement.setInt(3, order.getAmount());
		statement.setDate(4, Date.valueOf(order.getRequiredDate()));
		statement.setDate(5, Date.valueOf(order.getDeliveryDate()));
		statement.executeUpdate();
		System.out.println("New order placed\n");
	}

	public List<Order> readAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
//		PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders");
		PreparedStatement statement = connection.prepareStatement("select o.order_id, p.name as product, c.name as customer, o.amount, o.order_date, o.required_date, o.delivery_date "
				+ "from orders o "
				+ "left join products p on p.product_id = o.product_id "
				+ "left join customers c on c.customer_id = o.customer_id");
		ResultSet rs = statement.executeQuery();

		List<Order> orders = new ArrayList<>();
		while (rs.next()) {
			Order order = new Order();
			try {
				order.setId(rs.getInt("order_id"));
				order.setProduct(rs.getString("product"));
				order.setCustomer(rs.getString("customer"));
				order.setAmount(rs.getInt("amount"));
				order.setOrderDate(rs.getDate("order_date").toString());
				order.setRequiredDate(rs.getDate("required_date").toString());
				order.setDeliveryDate(rs.getDate("delivery_date").toString());
			} catch (NullPointerException e) {
			}
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

		while (rs.next()) {
			order = new Order();
			try {
				order.setId(rs.getInt("order_id"));
				order.setProductId(rs.getInt("product_id"));
				order.setCustomerId(rs.getInt("customer_id"));
				order.setAmount(rs.getInt("amount"));
				order.setOrderDate(rs.getString("order_date").toString());
				order.setRequiredDate(rs.getString("required_date").toString());
				order.setDeliveryDate(rs.getString("delivery_date").toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
		}

		return order;
	}

	public void update(Order order) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"UPDATE orders SET product_id = ?, customer_id = ?, amount = ?, required_date = ?, delivery_date = ? WHERE order_id = ?");

			statement.setInt(1, order.getProductId());
			statement.setInt(2, order.getCustomerId());
			statement.setInt(3, order.getAmount());
			statement.setDate(4, Date.valueOf(order.getRequiredDate()));
			statement.setDate(5, Date.valueOf(order.getDeliveryDate()));
			statement.setInt(6, order.getId());
			statement.executeUpdate();
		
	}

	public void delete(Order order) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();		
		PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");
		statement.setInt(1, order.getId());
		statement.executeUpdate();
		
		System.out.println("Ordern borttagen ur databasen\n");
	}

}
