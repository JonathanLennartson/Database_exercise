package main.presentation.customer;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Customer;
import persistence.DAO.CustomerDAO;

public class AddCustomer {
	
	public void add() throws SQLException {
	
	Scanner scanner = new Scanner(System.in);
	Customer customer = new Customer();
	CustomerDAO customerDAO = new CustomerDAO();
	
	System.out.println("Lägg till kund");
	System.out.println("Namn:");
	customer.setName(scanner.nextLine());
	
	System.out.println("Email:");
	customer.setEmail(scanner.nextLine());

	System.out.println("Adress:");
	customer.setAdress(scanner.nextLine());
	
	System.out.println("Kommentar:");
	customer.setCommentary(scanner.nextLine());
	
	System.out.println("Organisation:");
	customer.setOrganisation(scanner.nextLine());
	
	System.out.println("Rabattgrupp:");
	customer.setDiscountGroup(Integer.valueOf(scanner.nextLine()));
	
	customerDAO.create(customer);
	
	System.out.println();
	
	}
}
