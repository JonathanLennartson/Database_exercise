package main.presentation.employee;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuEmployeeJDBC {

	public static void show() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menu för anställda\n" 
					+ "1. Lägg till ny anställd\n" 
					+ "2. Lista alla anställda\n"
					+ "3. Se en anställd\n" 
					+ "4. Uppdatera anställd\n" 
					+ "5. Ta bort anställd\n" 
					+ "6. Återgå");
												
			String choice = scanner.nextLine();		
			
			switch (choice) {
				case "1": {
					AddEmployee.add(); 
					continue;
				}
				case "2": {
					GetAllEmployees.getAll();
					continue;
				}
				case "3": {
					GetSingleEmployee.get();
					continue;
				}
				case "4": {
					UpdateEmployee.update();
					continue;
				}
				case "5": {
					DeleteEmloyee.delete();
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
