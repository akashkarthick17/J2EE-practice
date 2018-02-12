package io.zilker.zbuy.bean;

public class ShoppingCart implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private long customerId, itemId;
	private int quantity;

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(long customerId, long itemId, int quantity) {
		super();
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
