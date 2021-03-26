package main.presentation.office;

import java.sql.SQLException;
import entities.Office;
import persistence.DAOJDBC.OfficeDAO;

public class GetAllOffices {

	public static void getAll() throws SQLException {
		OfficeDAO officeDAO = new OfficeDAO();
		
		System.out.println("Lista alla kontor");
		for(Office office : officeDAO.readAll()) {
			System.out.println(office);
		}
		System.out.println();
		
	}
}
