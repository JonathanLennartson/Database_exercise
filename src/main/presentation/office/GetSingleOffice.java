package main.presentation.office;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Office;
import persistence.DAO.OfficeDAO;

public class GetSingleOffice {

	public static void get() throws SQLException {
		OfficeDAO officeDAO = new OfficeDAO();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Välj ID på kontoret");
		Office office = officeDAO.read(scanner.nextInt());
		
		System.out.println(office);
		
	}
	
}
