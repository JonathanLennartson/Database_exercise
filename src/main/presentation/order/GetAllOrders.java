package main.presentation.order;

import java.sql.SQLException;

import entities.Order;
import persistence.DAO.OrderDAO;

public class GetAllOrders {

	public static void getAll() throws SQLException {
		OrderDAO orderDAO = new OrderDAO();
		
		System.out.println("Lista alla ordrar");
		for(Order order : orderDAO.readAll()) {
			System.out.println(order);
		}
		System.out.println();
		
	}

}
