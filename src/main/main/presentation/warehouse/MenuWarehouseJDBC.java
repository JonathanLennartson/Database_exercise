package main.presentation.warehouse;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuWarehouseJDBC {

	public static void show() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menu f�r lager\n" 
					+ "1. �ppna  nytt lager\n" 
					+ "2. Lista alla lager\n"
					+ "3. Uppdatera lager\n" 
					+ "4. St�ng lager\n" 
					+ "5. �terg�");
												
			String choice = scanner.nextLine();		
			
			switch (choice) {
				case "1": {
					AddWarehouse.add(); 
					continue;
				}
				case "2": {
					GetAllWarehouses.getAll();
					continue;
				}
				case "3": {
					UpdateWarehouse.update();
					continue;
				}
				case "4": {
					DeleteWarehouse.delete();
					continue;
				}
				case "5": {
					break;
				}
				
				default:	
					System.out.println("Ogiltigt val, f�rs�k igen\n");
					continue;
			}
			
			if (choice.equals("5")) {
				break;
			}
			
		}
	}
		
	

}
