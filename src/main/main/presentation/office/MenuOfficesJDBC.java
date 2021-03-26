package main.presentation.office;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuOfficesJDBC {

	public static void show() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Hantera kontor\n"
					+ "Vad vill du göra?\n"
					+ "1. Öppna nytt kontor\n"
					+ "2. Lista alla kontor\n"
					+ "3. Uppdatera kontor\n"
					+ "4. Stäng ett kontor\n"
					+ "5. Återgå");
			
			String choice = scanner.nextLine();
			
			switch (choice) {
			case "1": {
				AddOffice.add();
				continue;
			}

			case "2": {
				GetAllOffices.getAll();
				continue;
			}

			case "3": {
				UpdateOffice.update();
				continue;
			}

			case "4": {
				DeleteOffice.delete();
				continue;
			}
			
			case "5": {
				break;
			}

			default:
				System.out.println("Ogiltigt val, försök igen");
				continue;
			}
		
			if(choice.equals("5")) {
				break;
			}
		}
				
		
	}

}
