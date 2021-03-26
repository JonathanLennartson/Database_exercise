package main.presentation.office;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import entities.Office;
import persistence.DAOJDBC.OfficeDAO;

public class UpdateOffice {
	public static void update() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		OfficeDAO officeDAO = new OfficeDAO();
		
		List<Office> offices = officeDAO.readAll();
		for (Office o : offices) {
			System.out.println(o);
		}

		System.out.println("\nVilket kontor gäller det, välj ID?");
		int id = Integer.valueOf(scanner.nextLine());
		Office office = officeDAO.read(id);

		System.out.println("Vad vill du ändra:\n" 
				+ "1: Namn\n" 				
				+ "2: Adress\n" 
				+ "3: Stad");
				

		String choice = scanner.nextLine();

		switch (choice) {
		case "1": {
			System.out.println("Nytt namn:");
			office.setName(scanner.nextLine());
			break;
		}
		case "2": {
			System.out.println("Ny email:");
			office.setAdress(scanner.nextLine());
			break;
		}
		case "3": {
			System.out.println("Ny adress:");
			office.setCity(scanner.nextLine());
			break;
		}
		}
		officeDAO.update(office);
		
		System.out.println();
	
	}
}
