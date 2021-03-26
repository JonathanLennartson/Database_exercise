package main.presentation.complaint;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuComplaintJDBC {

	public static void show() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Hantera reklamationer\n"
					+ "Vad vill du göra?\n"
					+ "1. Lägg till ny reklamation\n"
					+ "2. Lista alla reklamationer\n"
					+ "3. Uppdatera reklamation\n"
					+ "4. Ta bort reklamation\n"
					+ "5. Återgå");
			
			String choice = scanner.nextLine();
			
			switch (choice) {
				case "1": {
					AddComplaint.add();
					continue;
				}
	
				case "2": {
					GetAllComplaint.getAll();
					continue;
				}
	
				case "3": {
					UpdateComplaint.update();
					continue;
				}
	
				case "4": {
					DeleteComplaint.delete();
					continue;
				}
				
				case "5": {
					break;
				}
				
				default:
					System.out.println("Ogiltigt val, försök igen\n");
					continue;
			}
			
			if(choice.equals("5")) {
				break;
			}
		}
		
	}

}
