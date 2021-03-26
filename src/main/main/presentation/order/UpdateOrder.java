package main.presentation.order;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Order;
import persistence.DAOJDBC.OrderDAO;

public class UpdateOrder {

	public static void update() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		OrderDAO orderDAO = new OrderDAO();

		for (Order o : orderDAO.readAll()) {
			System.out.println(o);
		}

		System.out.println("\nVilket anst�llningsID g�ller g�ller �ndringen?");
		int id = Integer.valueOf(scanner.nextLine());
		Order order = orderDAO.read(id);
		
		System.out.println(order);

		System.out.println("Vad vill du �ndra:\n" + "1: Produkt via ID\n" + "2: Kund via ID\n" + "3: M�ngd\n"
				+ "4: �nskat datum\n" + "5: Leverans datum");

		int choice = Integer.valueOf(scanner.nextLine());

		switch (choice) {
		case 1: {
			System.out.println("Annan produkt:");
			order.setProductId(scanner.nextInt());
			break;
		}
		case 2: {
			System.out.println("Annan kund:");
			order.setCustomerId(scanner.nextInt());
			break;
		}
		case 3: {
			System.out.println("Ny m�ngd:");
			order.setAmount(scanner.nextInt());
			break;
		}
		case 4: {
			System.out.println("Nytt �nskat leveransdatum:");
			order.setRequiredDate(scanner.nextLine());
			break;
		}
		case 5: {
			System.out.println("Nytt leveransdatum");
			order.setDeliveryDate(scanner.nextLine());
			break;
		}
		}
		orderDAO.update(order);

		System.out.println();

	}

}
