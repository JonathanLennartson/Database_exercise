package entities;

public class Complaint {

	private int id;
	private int customerId;
	private int employeeId;
	private String customer;
	private String employee;
	private String date;
	private String complaint;
	private int orderId;
	
		
	public Complaint() {
	}

	
	
	@Override
	public String toString() {
		return "Complaint [id = " + id + " | customer = " + customer + " | employeeId = " + employee + " | date = " + date
				+ " | complaint = " + complaint + " | orderId = " + orderId + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public String getCustomer() {
		return customer;
	}



	public void setCustomer(String customer) {
		this.customer = customer;
	}



	public String getEmployee() {
		return employee;
	}



	public void setEmployee(String employee) {
		this.employee = employee;
	}

}
