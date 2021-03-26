package main.presentation.complaint;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Complaint;
import entities.Employee;
import entities.Order;
import persistence.DAOJDBC.ComplaintDAO;
import persistence.DAOJDBC.CustomerDAO;
import persistence.DAOJDBC.EmployeeDAO;
import persistence.DAOJDBC.OrderDAO;

public class AddComplaint {

	public static void add() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		ComplaintDAO complaintDAO = new ComplaintDAO();
		Complaint complaint = new Complaint();
		CustomerDAO customerDAO = new CustomerDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		OrderDAO orderDAO = new OrderDAO();
		
		System.out.println("L�gg till ny reklamation");
		
		System.out.println("Skriv varf�r reklamationen sker");
		complaint.setComplaint(scanner.nextLine());		
		
		for(Order o : orderDAO.readAll()) {
			System.out.println(o);
		}
		System.out.println("Vilken order g�ller �rendet");
		int orderId = scanner.nextInt();
		complaint.setOrderId(orderId);
		complaint.setCustomerId(orderDAO.read(orderId).getCustomerId());
		
		for(Employee e : employeeDAO.readAll()) {
			System.out.println(e);
		}		
		System.out.println("Vilken anst�lld hanterade �rendet. V�lj ID.");
		complaint.setEmployeeId(scanner.nextInt());
		
		complaintDAO.create(complaint);
		
		System.out.println();
		
	}

}
