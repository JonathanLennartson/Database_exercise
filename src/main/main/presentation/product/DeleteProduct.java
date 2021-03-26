package main.presentation.product;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Product;
import persistence.DAOJDBC.ProductDAO;

public class DeleteProduct {

	public static void delete() throws SQLException {
		ProductDAO productDAO = new ProductDAO();
		Scanner scanner= new Scanner(System.in);
		
		for(Product p : productDAO.readAll()) {
			System.out.println(p);
		}
		
		System.out.println("\nVilken produkt vill du ta bort? Välj ID.");
		int choice = scanner.nextInt();
		productDAO.delete(choice);
		
	}

}
