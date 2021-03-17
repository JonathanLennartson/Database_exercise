package main.presentation.order;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Customer;
import entities.Order;
import entities.Product;
import persistence.DAO.CustomerDAO;
import persistence.DAO.OrderDAO;
import persistence.DAO.ProductDAO;

public class AddOrder {

	public static void add() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		OrderDAO orderDAO = new OrderDAO();
		ProductDAO productDAO = new ProductDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		Order order = new Order();
		Product product = new Product();
		

		System.out.println("Lägg ny order");		
		
		System.out.println("Önskat leveransdatum (format: yyyy-mm-dd)");		
		order.setRequiredDate(scanner.nextLine());	

		System.out.println("Leveransdatum (format: yyyy-mm-dd)");		
		order.setDeliveryDate(scanner.nextLine());
		
		for (Product p : productDAO.readAll()) {
			System.out.println(p);
		}
		System.out.println("ProduktID:");
		order.setProductId(scanner.nextInt());
		product = productDAO.read(order.getProductId());

		System.out.println("Antal:");
		order.setAmount(scanner.nextInt());
		product.setStock(product.getStock()-order.getAmount());
		
		for (Customer c : customerDAO.readAll()) {
			System.out.println(c);
		}
		System.out.println("KundID:");
		order.setCustomerId(scanner.nextInt());			
		
		productDAO.update(product);
		orderDAO.create(order);

		System.out.println();

	}

}
