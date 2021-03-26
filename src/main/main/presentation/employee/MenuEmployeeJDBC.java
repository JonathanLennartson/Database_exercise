package main.presentation.employee;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuEmployeeJDBC {

	public static void show() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menu f�r anst�llda\n" 
					+ "1. L�gg till ny anst�lld\n" 
					+ "2. Lista alla anst�llda\n"
					+ "3. Uppdatera anst�lld\n" 
					+ "4. Ta bort anst�lld\n" 
					+ "5. �terg�");
												
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
					UpdateEmployee.update();
					continue;
				}
				case "4": {
					DeleteEmloyee.delete();
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
