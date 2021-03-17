package persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Office;
import persistence.ConnectionFactory;

public class OfficeDAO implements DAO<Office> {

	@Override
	public void create(Office office) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO offices(name, adress, city) VALUES(?, ?, ?)");
		statement.setString(1, office.getName());
		statement.setString(2, office.getAdress());
		statement.setString(3, office.getCity());
		statement.executeUpdate();
		System.out.println("New office, " + office.getName() + ", added to database");

	}

	@Override
	public List<Office> readAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM offices");
		ResultSet rs = statement.executeQuery();

		List<Office> offices = new ArrayList<>();
		while (rs.next()) {
			Office o = new Office();
			o.setId(rs.getInt("office_id"));
			o.setName(rs.getString("name"));
			o.setAdress(rs.getString("adress"));
			o.setCity(rs.getString("city"));
			offices.add(o);
		}

		return offices;
	}

	@Override
	public Office read(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM offices WHERE office_id = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();

		Office o = null;
		if (rs.next()) {
			o = new Office();
			o.setId(rs.getInt("office_id"));
			o.setName(rs.getString("name"));
			o.setAdress(rs.getString("adress"));
			o.setCity(rs.getString("office_id"));
		}

		return o;
	}

	@Override
	public void update(Office office) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("UPDATE offices SET name = ?, adress = ?, city = ? WHERE office_id = ?");
		statement.setString(1, office.getName());
		statement.setString(2, office.getAdress());
		statement.setString(3, office.getCity());
		statement.setInt(4, office.getId());
		statement.executeUpdate();

	}

	@Override
	public void delete(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM offices WHERE office_id = ?");
		statement.setInt(1, id);
		statement.executeUpdate();
		System.out.println("Kontor borttagen ur databasen.\n");
	}

}
