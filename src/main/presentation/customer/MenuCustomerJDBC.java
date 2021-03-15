package main.presentation.customer;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuCustomerJDBC {
	
	public static void show() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Hantera kunder\n"
					+ "Vad vill du göra?\n"
					+ "1. Lägg till ny kund\n"
					+ "2. Lista alla kunder\n"
					+ "3. Se en kund\n"
					+ "4. Uppdatera kund\n"
					+ "5. Ta bort kund\n"
					+ "6. Återgå");
			
			String choice = scanner.nextLine();
			
			switch (choice) {
				case "1": {
					AddCustomer.add();
					continue;
				}
	
				case "2": {
					GetAllCustomers.getAll();
					continue;
				}
	
				case "3": {
					GetSingleCustomer.get();
					continue;
				}
	
				case "4": {
					UpdateCustomer.update();
					continue;
				}
	
				case "5": {
					DeleteCustomer.delete();
					continue;
				}
				
				case "6": {
					break;
				}
				
				default:
					System.out.println("Ogiltigt val, försök igen\n");
					continue;
			}
			
			if(choice.equals("6")) {
				break;
			}
		}
		
	}

}
