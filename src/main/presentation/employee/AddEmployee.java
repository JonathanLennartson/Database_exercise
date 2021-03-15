package main.presentation.employee;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Employee;
import persistence.DAO.EmployeeDAO;

public class AddEmployee {

	public static void add() throws SQLException {

		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		EmployeeDAO employeeDAO = new EmployeeDAO();

		System.out.println("L�gg till anst�lld");
		System.out.println("Namn:");
		employee.setName(scanner.nextLine());

		System.out.println("Email:");
		employee.setEmail(scanner.nextLine());

		System.out.println("Adress:");
		employee.setAdress(scanner.nextLine());

		System.out.println("Kommentar:");
		employee.setCommentary(scanner.nextLine());

		// Skriv ut vilka kontor som finns och v�lj ett efter dess id-nummer.

		System.out.println("Kontor:");
		employee.setOfficeId(Integer.valueOf(scanner.nextLine()));

		employeeDAO.create(employee);
		
		System.out.println();
	}
}
