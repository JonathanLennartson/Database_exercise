package main.presentation.employee;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Employee;
import entities.Office;
import persistence.DAOJDBC.EmployeeDAO;
import persistence.DAOJDBC.OfficeDAO;

public class AddEmployee {

	public static void add() throws SQLException {

		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		OfficeDAO officeDAO = new OfficeDAO();
		
		System.out.println("Lägg till anställd");
		System.out.println("Namn:");
		employee.setName(scanner.nextLine());

		System.out.println("Email:");
		employee.setEmail(scanner.nextLine());

		System.out.println("Adress:");
		employee.setAdress(scanner.nextLine());

		System.out.println("Kommentar:");
		employee.setCommentary(scanner.nextLine());

		System.out.println();
		for(Office office : officeDAO.readAll()) {
			System.out.println(office);
		}
		
		System.out.println("KontorsID:");
		employee.setOfficeId(Integer.valueOf(scanner.nextLine()));

		employeeDAO.create(employee);
		
		System.out.println();
	}
}
