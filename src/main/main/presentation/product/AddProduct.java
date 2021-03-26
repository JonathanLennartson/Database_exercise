package main.presentation.product;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Product;
import entities.Warehouse;
import persistence.DAOJDBC.ProductDAO;
import persistence.DAOJDBC.WarehouseDAO;

public class AddProduct {

	public static void add() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Product product = new Product();
		ProductDAO productDAO = new ProductDAO();
		WarehouseDAO warehouseDAO = new WarehouseDAO();
		
		System.out.println("Lägg till produkt");
		System.out.println("Namn:");
		product.setName(scanner.nextLine());

		System.out.println("Beskrivning:");
		product.setDescription(scanner.nextLine());

		System.out.println("Pris:");
		product.setPrice(Double.valueOf(scanner.nextLine()));
		
		System.out.println("Antal i lager:");
		product.setStock(scanner.nextInt());

		System.out.println();
		for(Warehouse warehouse : warehouseDAO.readAll()) {
			System.out.println(warehouse);
		}

		System.out.println("LagerID:");
		product.setWarehouseId(scanner.nextInt());

		productDAO.create(product);

		System.out.println();

	}

}
