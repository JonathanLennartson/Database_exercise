package main.presentation.customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import entities.Customer;
import persistence.DAO.CustomerDAO;

public class UpdateCustomer {

	@SuppressWarnings("resource")
	public static void update() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		CustomerDAO customerDAO = new CustomerDAO();
		
		List<Customer> customers = customerDAO.readAll();
		for (Customer c : customers) {
			System.out.println(c);
		}

		System.out.println("\nVilken kund gäller det, välj ID?");
		int id = Integer.valueOf(scanner.nextLine());
		Customer customer = customerDAO.read(id);

		System.out.println("Vad vill du ändra:\n" 
				+ "1: Namn\n" 				
				+ "2: Email\n" 
				+ "3: Adress\n" 
				+ "4: Kommentar\n"				
				+ "5: Organisation\n" 
				+ "6: Rabattgrupp");

		int choice = Integer.valueOf(scanner.nextLine());

		switch (choice) {
		case 1: {
			System.out.println("Nytt namn:");
			customer.setName(scanner.nextLine());
			break;
		}
		case 2: {
			System.out.println("Ny email:");
			customer.setEmail(scanner.nextLine());
			break;
		}
		case 3: {
			System.out.println("Ny adress:");
			customer.setAdress(scanner.nextLine());
			break;
		}
		case 4: {
			System.out.println("Ny kommentar:");
			customer.setCommentary(scanner.nextLine());
			break;
		}
		case 5: {
			System.out.println("Ny organisation:");
			customer.setOrganisation(scanner.nextLine());
			break;
		}
		case 6: {
			System.out.println("Ny rabattgrupp:");
			customer.setDiscountGroup(Integer.valueOf(scanner.nextLine()));
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		customerDAO.update(customer);
		
		System.out.println();
	}

}
