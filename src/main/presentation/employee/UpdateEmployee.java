package main.presentation.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import entities.Employee;
import persistence.DAO.EmployeeDAO;

public class UpdateEmployee {
	
	public static void update() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		List<Employee> employees = employeeDAO.readAll();
		for (Employee e : employees) {
			System.out.println(e);
		}

		System.out.println("\nVilket anställningsID gäller?");
		int id = Integer.valueOf(scanner.nextLine());
		Employee employee = employeeDAO.read(id);

		System.out.println("Vad vill du ändra:\n" 
				+ "1: Namn\n" 				
				+ "2: Email\n" 
				+ "3: Adress\n" 
				+ "4: Kommentar\n"				
				+ "5: Kontor");

		int choice = Integer.valueOf(scanner.nextLine());

		switch (choice) {
		case 1: {
			System.out.println("Nytt namn:");
			employee.setName(scanner.nextLine());
			break;
		}
		case 2: {
			System.out.println("Ny email:");
			employee.setEmail(scanner.nextLine());
			break;
		}
		case 3: {
			System.out.println("Ny adress:");
			employee.setAdress(scanner.nextLine());
			break;
		}
		case 4: {
			System.out.println("Ny kommentar:");
			employee.setCommentary(scanner.nextLine());
			break;
		}
		case 5: {
			System.out.println("Nytt kontor:");
			employee.setOfficeId(Integer.valueOf(scanner.nextLine()));
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		employeeDAO.update(employee);		
		
		scanner.close();
		
		System.out.println();
	}
		
	}


