package io.zilker.zbuy.bean;

public class Orders implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private long orderId, groceryId;
	private String orderDate, customerName;
	private long customerId;
	private double amount;
	private String status;
	private String groceryName;

	public Orders() {
		super();
	}

	public Orders(long orderId, String orderDate, String customerName, double amount, String status,
			String groceryName) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.amount = amount;
		this.status = status;
		this.groceryName = groceryName;
	}

	public Orders(long orderId, long groceryId, String orderDate, String customerName, long customerId, double amount,
			String status) {
		super();
		this.orderId = orderId;
		this.groceryId = groceryId;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.customerId = customerId;
		this.amount = amount;
		this.status = status;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(long groceryId) {
		this.groceryId = groceryId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getGroceryName() {
		return groceryName;
	}

	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}

}
