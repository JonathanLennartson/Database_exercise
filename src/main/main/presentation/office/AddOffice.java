package main.presentation.office;

import java.sql.SQLException;
import java.util.Scanner;
import entities.Office;
import persistence.DAOJDBC.OfficeDAO;

public class AddOffice {
	
	public static void add() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		Office office = new Office();
		OfficeDAO officeDAO = new OfficeDAO();
		
		System.out.println("Lägg till kontor");
		System.out.println("Namn:");
		office.setName(scanner.nextLine());

		System.out.println("Adress:");
		office.setAdress(scanner.nextLine());
		
		System.out.println("Stad:");
		office.setCity(scanner.nextLine());
		
		officeDAO.create(office);
		
		System.out.println();
		
	}

}
