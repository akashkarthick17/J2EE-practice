package io.zilker.zbuy.bean;

public class OrderDetails implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private long itemId;
	private String itemName;
	private double totalPrice;
	private int totalQuantity;

	public OrderDetails() {
		super();
	}

	public OrderDetails(long itemId, String itemName, double totalPrice, int totalQuantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
