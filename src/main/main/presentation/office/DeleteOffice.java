package main.presentation.office;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import entities.Office;
import persistence.DAOJDBC.OfficeDAO;

public class DeleteOffice {

	public static void delete() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		OfficeDAO officeDAO = new OfficeDAO();
		
		for(Office o : officeDAO.readAll()) {
			System.out.println(o);
		}
		
		System.out.println("\nVilket kontor vill du ta bort? Välj ID.");
		int choice = scanner.nextInt();
		
		officeDAO.delete(choice);
		
	}

}
