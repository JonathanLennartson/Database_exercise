package main.presentation.complaint;

import java.sql.SQLException;

import entities.Complaint;
import persistence.DAOJDBC.ComplaintDAO;

public class GetAllComplaint {

	public static void getAll() throws SQLException {
		ComplaintDAO complaintDAO = new ComplaintDAO();
		
		System.out.println("Lista alla returer");
		for(Complaint c : complaintDAO.readAll()) {
			System.out.println(c);
		}
		System.out.println();
	}

}
