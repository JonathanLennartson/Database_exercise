package main.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import main.presentation.complaint.MenuComplaintJDBC;
import main.presentation.customer.MenuCustomerJDBC;
import main.presentation.employee.MenuEmployeeJDBC;
import main.presentation.office.MenuOfficesJDBC;
import main.presentation.order.MenuOrderJDBC;
import main.presentation.product.MenuProductJDBC;
import main.presentation.warehouse.MenuWarehouseJDBC;

public class MenuJDBC {

	public static void jdbc() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		String choice;

		while (true) {
			System.out.println("Meny för JDBC. \nVad vill du göra?\n" 
					+ "1. Se kontorsmenu\n"
					+ "2. Se menu för anställda\n" 
					+ "3. Se kundmenu\n" 
					+ "4. Se produktmenu\n" 
					+ "5. Se lagermenu\n"
					+ "6. Se ordermenu\n" 
					+ "7. Se reklamationsmenu\n" 
					+ "8. Återgå");

			choice = scanner.nextLine();

			switch (choice) {
			case "1": {
				MenuOfficesJDBC.show();
				continue;
			}

			case "2": {
				MenuEmployeeJDBC.show();
				continue;
			}

			case "3": {
				MenuCustomerJDBC.show();
				continue;
			}

			case "4": {
				MenuProductJDBC.show();
				continue;
			}

			case "5": {
				MenuWarehouseJDBC.show();
				continue;
			}

			case "6": {
				MenuOrderJDBC.show();
				continue;
			}

			case "7": {
				MenuComplaintJDBC.show();
				continue;
			}

			case "8": {
				break;
			}
			default:

				System.out.println("Ogiltigt val, försök igen");
				continue;

			}
			
			break;
		}
		
	}

}
