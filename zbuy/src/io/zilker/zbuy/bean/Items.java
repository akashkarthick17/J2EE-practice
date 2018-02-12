package io.zilker.zbuy.bean;

public class Items implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long itemId, groceryId, categoryId;
	private String itemName, itemImage, units, categoryName, itemDescription, ingredients;
	private double itemPrice;
	private int quantity;

	public Items() {
		super();
	}

	public Items(long itemId, long groceryId, long categoryId, String itemName, String itemImage, String units,
			String categoryName, double itemPrice, int quantity) {
		super();
		this.itemId = itemId;
		this.groceryId = groceryId;
		this.categoryId = categoryId;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.units = units;
		this.categoryName = categoryName;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
	}

	public Items(long itemId, long groceryId, long categoryId, String itemName, String itemImage, String units,
			String categoryName, String itemDescription, String ingredients, double itemPrice, int quantity) {
		super();
		this.itemId = itemId;
		this.groceryId = groceryId;
		this.categoryId = categoryId;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.units = units;
		this.categoryName = categoryName;
		this.itemDescription = itemDescription;
		this.ingredients = ingredients;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(long groceryId) {
		this.groceryId = groceryId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

}
