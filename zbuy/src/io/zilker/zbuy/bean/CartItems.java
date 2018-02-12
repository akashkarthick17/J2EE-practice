package io.zilker.zbuy.bean;

public class CartItems implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private long itemId, categoryId, groceryId;
	private String itemName, itemImage, groceryName;
	private double itemPrice, totalPrice;
	private int quantity, totalQuantity;

	public CartItems() {
		super();
	}

	public CartItems(long itemId, long categoryId, long groceryId, String itemName, String itemImage, double itemPrice,
			double totalPrice, int quantity, int totalQuantity, String groceryName) {
		super();
		this.itemId = itemId;
		this.categoryId = categoryId;
		this.groceryId = groceryId;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.itemPrice = itemPrice;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.totalQuantity = totalQuantity;
		this.groceryName = groceryName;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(long groceryId) {
		this.groceryId = groceryId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
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

	public String getGroceryName() {
		return groceryName;
	}

	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
