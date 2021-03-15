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
					+ "3. Se en anst�lld\n" 
					+ "4. Uppdatera anst�lld\n" 
					+ "5. Ta bort anst�lld\n" 
					+ "6. �terg�");
												
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
					System.out.println("Ogiltigt val, f�rs�k igen\n");
					continue;
			}
			
			if (choice.equals("6")) {
				break;
			}
			
		}
	}

}
