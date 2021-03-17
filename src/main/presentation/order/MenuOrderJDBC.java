package main.presentation.order;

import java.sql.SQLException;
import java.util.Scanner;


public class MenuOrderJDBC {

	public static void show() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menu för hantera ordrar\n" 
					+ "1. Lägg ny order\n" 
					+ "2. Lista alla ordrar\n"
					+ "3. Uppdatera order\n" 
					+ "4. Ta bort order\n"
					+ "5. Lista mest lönsamma kunden\n"
					+ "6. Återgå");
												
			String choice = scanner.nextLine();		
			
			switch (choice) {
				case "1": {
					AddOrder.add(); 
					continue;
				}
				case "2": {
					GetAllOrders.getAll();
					continue;
				}
				case "3": {
					UpdateOrder.update();
					continue;
				}
				case "4": {
					DeleteOrder.delete();
					continue;
				}
				case "5": {
					
					continue;
				}
				
				case "6": {
					break;
				}
				
				default:	
					System.out.println("Ogiltigt val, försök igen\n");
					continue;
			}
			
			if (choice.equals("6")) {
				break;
			}
			
		}
		
	}

}
