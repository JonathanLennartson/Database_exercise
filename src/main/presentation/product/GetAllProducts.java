package main.presentation.product;

import java.sql.SQLException;

import entities.Product;
import persistence.DAO.ProductDAO;

public class GetAllProducts {

	public static void getAll() throws SQLException {
		ProductDAO productDAO = new ProductDAO();
		
		System.out.println("Lista alla produkter");
		for(Product product : productDAO.readAll()) {
			System.out.println(product);
		}
		System.out.println();
		
	}

}
