package main;

import java.sql.SQLException;
import java.util.List;

import entities.Customer;
import main.presentation.customer.AddCustomer;
import main.presentation.customer.GetAllCustomers;
import main.presentation.customer.GetSingleCustomer;
import main.presentation.customer.UpdateCustomer;
import main.presentation.employee.AddEmployee;
import main.presentation.employee.GetAllEmployees;
import main.presentation.employee.GetSingleEmployee;
import main.presentation.employee.UpdateEmployee;
import persistence.DAO.CustomerDAO;
import persistence.DAO.EmployeeDAO;

public class Main {

	public static void main(String[] args) throws NumberFormatException, SQLException  {
		CustomerDAO customerDAO = new CustomerDAO();		
		GetSingleCustomer getSingleCustomer = new GetSingleCustomer();		
		UpdateCustomer updateCustomer = new UpdateCustomer();
		AddCustomer addCustomer = new AddCustomer();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		AddEmployee addEmployee = new AddEmployee();
		GetAllCustomers getAllCustomers = new GetAllCustomers();
		
		
//		getAllCustomers.getAll();
//		GetAllEmployees.getAll();
//		addEmployee.addEmployee();
		
//		GetSingleEmployee.get();
		
//		UpdateEmployee.update();
		
//		addCustomer.addCustomer();
		
//		List<Customer> customers = customerDAO.readAll();
//		for(Customer c : customers) {
//			System.out.println("kund: " + c);
//		}
		
		
		updateCustomer.update();		
//		getSingleCustomer.getCustomer();

	}

}
