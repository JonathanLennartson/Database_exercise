package entities;


public class Customer {

	private int id;
	private String name;
	private String email;
	private String adress;
	private String commentary;
	private String organisation;
	private int discountGroup;	
	
	
	
	@Override
	public String toString() {
		return "[Customer id = " + id + " | name = " + name + " | email = " + email + " | organisation = " + organisation + "]";
	}


	public Customer() {
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public int getDiscountGroup() {
		return discountGroup;
	}

	public void setDiscountGroup(int discountGroup) {
		this.discountGroup = discountGroup;
	}

}
