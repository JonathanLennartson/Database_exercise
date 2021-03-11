package main.presentation.customer;

import java.sql.SQLException;
import java.util.Scanner;
import entities.Customer;
import persistence.DAO.CustomerDAO;

public class GetSingleCustomer {
	
	
	public void get() throws NumberFormatException, SQLException {
		Scanner scanner = new Scanner(System.in);		
		CustomerDAO customerDAO = new CustomerDAO();
		
		System.out.println("Välj ID på kunden:");
		Customer customer = customerDAO.read(Integer.valueOf(scanner.nextLine()));
		
		System.out.println(customer);
		
	}
	
}
