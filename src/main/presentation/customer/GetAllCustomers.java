package main.presentation.customer;

import java.sql.SQLException;
import entities.Customer;
import persistence.DAO.CustomerDAO;

public class GetAllCustomers {
	
	public static void getAll() throws SQLException {
		CustomerDAO customerDAO = new CustomerDAO();
		
		System.out.println("Lista alla kunder");
		for(Customer c : customerDAO.readAll()) {
			System.out.println(c);
		}
		System.out.println();
	}
}
