package main.presentation.product;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuProductJDBC {

	public static void show() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Menu f�r produkter\n" 
					+ "1. L�gg till ny produkt\n" 
					+ "2. Lista alla produkter\n"
					+ "3. Uppdatera produkt\n" 
					+ "4. Ta bort produkt\n"
					+ "5. Lista produkter med lagersaldo under 10\n" 
					+ "6. �terg�");
												
			String choice = scanner.nextLine();		
			
			switch (choice) {
				case "1": {
					AddProduct.add(); 
					continue;
				}
				case "2": {
					GetAllProducts.getAll();
					continue;
				}
				case "3": {
					UpdateProduct.update();
					continue;
				}
				case "4": {
					DeleteProduct.delete();
					continue;
				}
				case "5": {
					LowStock.show();
					continue;
				}
				case "6": {
					break;
				}
				
				default:	
					System.out.println("Ogiltigt val, f�rs�k igen\n");
					continue;
			}
			
			if (choice.equals("6")) {
				break;
			}
			
		}
		
	}

}
