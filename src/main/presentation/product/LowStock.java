package main.presentation.product;

import java.sql.SQLException;

import entities.Product;
import persistence.DAO.ProductDAO;

public class LowStock {

	public static void show() throws SQLException {
		ProductDAO productDAO = new ProductDAO();
		
		System.out.println("Produkter med lagersaldo under 10");
		for(Product product : productDAO.lowStock()) {
			System.out.println(product);
		}
		System.out.println();
		
		
	}

}
