package persistence.DAOJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Warehouse;
import persistence.ConnectionFactory;

public class WarehouseDAO implements DAO<Warehouse> {

	@Override
	public void create(Warehouse warehouse) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO warehouses(name, adress, city) VALUES(?,?,?)");
		statement.setString(1, warehouse.getName());
		statement.setString(2, warehouse.getAdress());
		statement.setString(3, warehouse.getCity());
		statement.executeUpdate();
		System.out.println("New warehouse added\n");
	}

	@Override
	public List<Warehouse> readAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM warehouses");
		ResultSet rs = statement.executeQuery();

		List<Warehouse> warehouses = new ArrayList<>();
		while (rs.next()) {
			Warehouse warehouse = new Warehouse();
			warehouse.setId(rs.getInt("warehouse_id"));
			warehouse.setName(rs.getString("name"));
			warehouse.setAdress(rs.getString("adress"));
			warehouse.setCity(rs.getString("city"));
			warehouses.add(warehouse);
		}
		return warehouses;

	}

	@Override
	public Warehouse read(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM warehouses WHERE warehouse_id = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();

		Warehouse warehouse = null;

		while (rs.next()) {
			warehouse = new Warehouse();
			warehouse.setId(rs.getInt("warehouse_id"));
			warehouse.setName(rs.getString("name"));
			warehouse.setAdress(rs.getString("adress"));
			warehouse.setCity(rs.getString("city"));
		}
		return warehouse;
	}

	@Override
	public void update(Warehouse warehouse) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("UPDATE warehouses SET name = ?, adress = ?, city = ? WHERE warehouse_id = ?");
		statement.setString(1, warehouse.getName());
		statement.setString(2, warehouse.getAdress());
		statement.setString(3, warehouse.getCity());
		statement.setInt(4, warehouse.getId());
		statement.executeUpdate();

	}

	@Override
	public void delete(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM warehouses WHERE warehouse_id = ?");
		statement.setInt(1, id);
		statement.executeUpdate();

		System.out.println("Lager borttagen ur databasen\n");

	}

}
