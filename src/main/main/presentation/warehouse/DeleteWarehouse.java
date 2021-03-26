package main.presentation.warehouse;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Warehouse;
import persistence.DAOJDBC.WarehouseDAO;

public class DeleteWarehouse {

	public static void delete() throws SQLException {
		WarehouseDAO warehouseDAO = new WarehouseDAO();
		Scanner scanner= new Scanner(System.in);
		
		for(Warehouse w : warehouseDAO.readAll()) {
			System.out.println(w);
		}
		
		System.out.println("\nVilket lager vill du ta bort? Välj ID.");
		int choice = scanner.nextInt();
		warehouseDAO.delete(choice);
	}

}
