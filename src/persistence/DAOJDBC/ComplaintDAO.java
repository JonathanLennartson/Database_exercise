package persistence.DAOJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Complaint;
import entities.Employee;
import persistence.ConnectionFactory;

public class ComplaintDAO implements DAO<Complaint> {

	@Override
	public void create(Complaint complaint) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO complaints(customer_id, employee_id, complaint_cause, order_id) VALUES(?,?,?,?)");
		statement.setInt(1, complaint.getCustomerId());
		statement.setInt(2, complaint.getEmployeeId());
		statement.setString(3, complaint.getComplaint());
		statement.setInt(4, complaint.getOrderId());
		statement.executeUpdate();
		System.out.println("New complaint recieved\n");
	}

	@Override
	public List<Complaint> readAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
//		PreparedStatement statement = connection.prepareStatement("SELECT * FROM complaints");
		PreparedStatement statement = connection.prepareStatement("select co.complaint_id, cu.name as customer, e.employee_id as employee, co.complaint_date as date, co.complaint_cause as cause, o.order_id "
				+ "from complaints co "
				+ "left join customers cu on cu.customer_id = co.customer_id "
				+ "left join employees e on e.employee_id = co.employee_id "
				+ "left join orders o on o.order_id = co.order_id;");
		ResultSet rs = statement.executeQuery();

		List<Complaint> complaints = new ArrayList<>();
		while (rs.next()) {
			Complaint complaint = new Complaint();
			complaint.setId(rs.getInt("complaint_id"));
			complaint.setCustomer(rs.getString("customer"));
			complaint.setEmployee(rs.getString("employee"));
			complaint.setDate(rs.getString("date"));
			complaint.setComplaint(rs.getString("cause"));
			complaint.setOrderId(rs.getInt("order_id"));
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
			complaint.setId(rs.getInt("complaint_id"));
			complaint.setCustomerId(rs.getInt("customer_id"));
			complaint.setEmployeeId(rs.getInt("employee_id"));
			complaint.setDate(rs.getString("complaint_date"));
			complaint.setComplaint(rs.getString("complaint_cause"));
			complaint.setOrderId(rs.getInt("order_id"));
		}

		return complaint;
	}

	@Override
	public void update(Complaint complaint) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE complaints SET customer_id = ?, "
				+ "employee_id = ?, complaint_cause = ? WHERE complaint_id = ?");
		statement.setInt(1, complaint.getCustomerId());
		statement.setInt(2, complaint.getEmployeeId());
		statement.setString(3, complaint.getComplaint());
		statement.setInt(4, complaint.getId());
		statement.executeUpdate();

	}

	@Override
	public void delete(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM complaints WHERE complaint_id = ?");
		statement.setInt(1, id);
		statement.executeUpdate();

		System.out.println("Reklamationen borttagen ur databasen\n");

	}

}
