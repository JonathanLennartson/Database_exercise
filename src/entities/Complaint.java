package entities;

public class Complaint {

	private int id;
	private int customerId;
	private int employeeId;
	private String date;
	private String complaint;
	private Boolean handled;

		
	public Complaint() {
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

	public Boolean getHandled() {
		return handled;
	}

	public void setHandled(Boolean handled) {
		this.handled = handled;
	}
}
