package main.presentation.warehouse;

import java.sql.SQLException;
import java.util.Scanner;
import entities.Warehouse;
import persistence.DAO.WarehouseDAO;

public class AddWarehouse {

	public static void add() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Warehouse warehouse = new Warehouse();
		WarehouseDAO warehouseDAO = new WarehouseDAO();
		
		System.out.println("Lägg till anställd");
		System.out.println("Namn:");
		warehouse.setName(scanner.nextLine());

		System.out.println("Adress:");
		warehouse.setAdress(scanner.nextLine());

		System.out.println("Stad:");
		warehouse.setCity(scanner.nextLine());
	
		warehouseDAO.create(warehouse);
		
		System.out.println();
		
	}

}
