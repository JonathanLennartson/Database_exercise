package main.presentation.product;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import entities.Product;
import entities.Warehouse;
import persistence.DAOJDBC.ProductDAO;
import persistence.DAOJDBC.WarehouseDAO;

public class UpdateProduct {

	public static void update() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		ProductDAO productDAO = new ProductDAO();
		WarehouseDAO warehouseDAO = new WarehouseDAO();
		
		for (Product p : productDAO.readAll()) {
			System.out.println(p);
		}

		System.out.println("\nVilket anställningsID gäller gäller ändringen?");
		int id = Integer.valueOf(scanner.nextLine());
		Product product = productDAO.read(id);

		System.out.println("Vad vill du ändra:\n" 
				+ "1: Namn\n" 				
				+ "2: Beskrivning\n" 
				+ "3: Pris\n" 
				+ "4: Antal i lager\n"				
				+ "5: Lager");

		int choice = Integer.valueOf(scanner.nextLine());

		switch (choice) {
		case 1: {
			System.out.println("Nytt namn:");
			product.setName(scanner.nextLine());
			break;
		}
		case 2: {
			System.out.println("Ny beskrivning:");
			product.setDescription(scanner.nextLine());
			break;
		}
		case 3: {
			System.out.println("Nytt pris:");
			product.setPrice(Double.valueOf(scanner.nextLine()));
			break;
		}
		case 4: {
			System.out.println("Nytt antal i lager:");
			product.setStock(scanner.nextInt());
			break;
		}
		case 5: {			
			System.out.println();
			for(Warehouse warehouse : warehouseDAO.readAll()) {
				System.out.println(warehouse);
			}
			
			System.out.println("Nytt lager:");
			product.setWarehouseId(scanner.nextInt());
			break;
		}
		
		}
		
		productDAO.update(product);
		
		System.out.println();
		
	}

}
