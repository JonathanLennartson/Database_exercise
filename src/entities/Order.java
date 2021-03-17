package entities;

public class Order {

	private int id;
	private int productId;	
	private int customerId;
	private String product;
	private String customer;
	private int amount;
	private String orderDate;
	private String requiredDate;
	private String deliveryDate;
	

	
	public Order() {
	}

	
	@Override
	public String toString() {
		return "Order [id = " + id + " | product = " + product + " | customer = " + customer + " | amount = " + amount
				+ " | orderDate = " + orderDate + " | requiredDate = " + requiredDate + " | deliveryDate = " + deliveryDate
				+ "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public String getCustomer() {
		return customer;
	}


	public void setCustomer(String customer) {
		this.customer = customer;
	}

}
