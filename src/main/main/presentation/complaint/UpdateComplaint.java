package main.presentation.complaint;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Complaint;
import persistence.DAOJDBC.ComplaintDAO;

public class UpdateComplaint {

	public static void update() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		ComplaintDAO complaintDAO = new ComplaintDAO();
		
		for (Complaint c : complaintDAO.readAll()) {
			System.out.println(c);
		}

		System.out.println("\nVilken retur gäller det, välj ID?");
		int id = Integer.valueOf(scanner.nextLine());
		Complaint complaint = complaintDAO.read(id);

		System.out.println("Vad vill du ändra:\n" 
				+ "1: KundID\n" 				
				+ "2: Anställdes ID\n" 
				+ "3: Anledning till retur\n");

		int choice = Integer.valueOf(scanner.nextLine());

		switch (choice) {
		case 1: {
			System.out.println("Uppdatera kundID:");
			complaint.setCustomerId(scanner.nextInt());
			break;
		}
		case 2: {
			System.out.println("Uppdatera anställdes ID:");
			complaint.setEmployeeId(scanner.nextInt());
			break;
		}
		case 3: {
			System.out.println("Uppdatera returbeskrivning:");
			complaint.setComplaint(scanner.nextLine());
			break;
		}
		}
		
		complaintDAO.update(complaint);
		
		System.out.println();
		
	}

}
