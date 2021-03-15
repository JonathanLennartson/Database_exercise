package persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Complaint;
import persistence.ConnectionFactory;

public class ComplaintDAO implements DAO<Complaint> {

	@Override
	public void create(Complaint complaint) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO complaints(customer_id, employee_id, complaint_cause, handled) VALUES(?,?,?,?)");
		statement.setInt(1, complaint.getCustomerId());
		statement.setInt(2, complaint.getEmployeeId());
		statement.setString(3, complaint.getComplaint());
		statement.setBoolean(4, false);
		statement.executeUpdate();
		System.out.println("New complaint recieved\n");
	}

	@Override
	public List<Complaint> readAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM complaints");
		ResultSet rs = statement.executeQuery();

		List<Complaint> complaints = new ArrayList<>();
		while (rs.next()) {
			Complaint complaint = new Complaint();
			complaint.setId(rs.getInt("product_id"));
			complaint.setCustomerId(rs.getInt("customer_id"));
			complaint.setEmployeeId(rs.getInt("employee_id"));
			complaint.setDate(rs.getString("complaint_date"));
			complaint.setComplaint(rs.getString("complaint_cause"));
			complaint.setHandled(rs.getBoolean("handled"));
			complaint.setHandled(rs.getBoolean("handled"));
			complaints.add(complaint);
		}

		return complaints;
	}

	@Override
	public Complaint read(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM complaints WHERE complaint_id = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();

		Complaint complaint = null;
		
		while (rs.next()) {
			complaint = new Complaint();
			complaint.setId(rs.getInt("product_id"));
			complaint.setCustomerId(rs.getInt("customer_id"));
			complaint.setEmployeeId(rs.getInt("employee_id"));
			complaint.setDate(rs.getString("complaint_date"));
			complaint.setComplaint(rs.getString("complaint_cause"));
		}

		return complaint;
	}

	@Override
	public void update(Complaint complaint) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();		
		PreparedStatement statement = connection.prepareStatement("UPDATE warehouse SET "
				+ "handled = ?, "
				+ "WHERE complaint_id = ?");
		statement.setBoolean(1, complaint.getHandled());
		statement.executeUpdate();

	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
