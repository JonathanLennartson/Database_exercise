package main.presentation.complaint;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Complaint;
import persistence.DAOJDBC.ComplaintDAO;

public class DeleteComplaint {

	public static void delete() throws SQLException {
		ComplaintDAO complaintDAO = new ComplaintDAO();
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		for (Complaint c : complaintDAO.readAll()) {
			System.out.println(c);
		}
		System.out.println("Vilken reklamation vill du ta bort? Välj ID");
		complaintDAO.delete(scanner.nextInt());
		
		System.out.println("Returen borttagen ur databasen");

	}

}
