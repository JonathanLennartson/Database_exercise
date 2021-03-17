package main.presentation.warehouse;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Warehouse;
import persistence.DAO.WarehouseDAO;

public class UpdateWarehouse {

	public static void update() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		WarehouseDAO warehouseDAO = new WarehouseDAO();
		
		for (Warehouse w : warehouseDAO.readAll()) {
			System.out.println(w);
		}

		System.out.println("\nVilket lagerID gäller ändringen?");
		int id = Integer.valueOf(scanner.nextLine());
		Warehouse warehouse = warehouseDAO.read(id);

		System.out.println("Vad vill du ändra:\n" 
				+ "1: Namn\n"  
				+ "2: Adress\n" 
				+ "3: Stad");

		int choice = Integer.valueOf(scanner.nextLine());

		switch (choice) {
		case 1: {
			System.out.println("Nytt namn:");
			warehouse.setName(scanner.nextLine());
			break;
		}
		case 2: {
			System.out.println("Ny adress:");
			warehouse.setAdress(scanner.nextLine());
			break;
		}
		case 3: {
			System.out.println("Ny stad:");
			warehouse.setCity(scanner.nextLine());
			break;
		}
		}
		
		warehouseDAO.update(warehouse);
		
		System.out.println();
		
	}

}
