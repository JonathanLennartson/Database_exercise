package persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import persistence.ConnectionFactory;

public class ProductDAO implements DAO<Product> {

	@Override
	public void create(Product product) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO products(name, description, price, in_stock, warehouse) VALUES(?,?,?,?,?)");
		statement.setString(1, product.getName());
		statement.setString(2, product.getDescription());
		statement.setDouble(3, product.getPrice());
		statement.setInt(4, product.getStock());
		statement.setInt(5, product.getWarehouseId());
		statement.executeUpdate();
		System.out.println("New product, " + product.getName() + " added in database\n");
	}

	@Override
	public List<Product> readAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
		ResultSet rs = statement.executeQuery();
		
		List<Product> products = new ArrayList<>();
		while(rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt("product_id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getDouble("price"));
			product.setStock(rs.getInt("in_stock"));
			product.setWarehouseId(rs.getInt("warehouse"));
			products.add(product);
		}		
		return products;
	}

	@Override
	public Product read(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE product_id = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		
		Product product = null;
		
		while(rs.next()) {
			product = new Product();
			product.setId(rs.getInt("product_id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getDouble("price"));
			product.setStock(rs.getInt("in_stock"));
			product.setWarehouseId(rs.getInt("warehouse"));
		}
		
		return product;
	}

	@Override
	public void update(Product product) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();		
		PreparedStatement statement = connection.prepareStatement("UPDATE products SET "
				+ "name = ?, "
				+ "description = ?, "
				+ "price = ?, "
				+ "in_stock = ?, "
				+ "warehouse = ? "
				+ "WHERE product_id = ?");
		statement.setString(1, product.getName());
		statement.setString(2, product.getDescription());
		statement.setDouble(3, product.getPrice());
		statement.setInt(4, product.getStock());
		statement.setInt(5, product.getWarehouseId());
		statement.setInt(6, product.getId());
		statement.executeUpdate();
		
	}

	@Override
	public void delete(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE product_id = ?");
		statement.setInt(1, id);
		statement.executeUpdate();
		
		System.out.println("Produkt borttagen ur databasen\n");
		
	}

}
