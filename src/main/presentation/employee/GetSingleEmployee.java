package main.presentation.employee;

import java.sql.SQLException;
import java.util.Scanner;

import entities.Employee;
import persistence.DAO.EmployeeDAO;

public class GetSingleEmployee {
	
	public static void get() throws NumberFormatException, SQLException {
		Scanner scanner = new Scanner(System.in);		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		System.out.println("Välj ID på den anställda:");
		Employee employee = employeeDAO.read(Integer.valueOf(scanner.nextLine()));
		
		System.out.println(employee);
		
	}

}
