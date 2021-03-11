package main.presentation.employee;

import java.sql.SQLException;

import entities.Employee;
import persistence.DAO.EmployeeDAO;

public class GetAllEmployees {

	public static void getAll() throws SQLException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		System.out.println("Lista alla anställda");		
		for(Employee e : employeeDAO.readAll()) {
			System.out.println(e);
		}
		System.out.println();
		
	}
	
}
