package main.presentation.customer;

import java.sql.SQLException;
import java.util.Scanner;
import entities.Customer;
import persistence.DAO.CustomerDAO;

public class GetSingleCustomer {
	
	
	public void get() throws NumberFormatException, SQLException {
		Scanner scanner = new Scanner(System.in);		
		CustomerDAO customerDAO = new CustomerDAO();
		
		System.out.println("V�lj ID p� kunden:");
		Customer customer = customerDAO.read(Integer.valueOf(scanner.nextLine()));
		
		System.out.println(customer);
		
	}
	
}
