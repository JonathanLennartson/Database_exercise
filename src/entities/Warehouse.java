package entities;

public class Warehouse {

	private int id;
	private String name;
	private String adress;
	private String city;

	
	public Warehouse() {
	}

	
	@Override
	public String toString() {
		return "Warehouse [id = " + id + " | name = " + name + " | adress = " + adress + " | city = " + city + "]";
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

}
