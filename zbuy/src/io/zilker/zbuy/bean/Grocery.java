package io.zilker.zbuy.bean;

public class Grocery implements java.io.Serializable, Comparable<Object> {

	private static final long serialVersionUID = 1L;

	private long groceryId;
	private String groceryName, groceryLocation;
	private double groceryLatitude, groceryLongitude, groceryDistance;

	public Grocery() {
		super();
	}

	public Grocery(long groceryId, String groceryName, String groceryLocation, double groceryLatitude,
			double groceryLongitude, double groceryDistance) {
		super();
		this.groceryId = groceryId;
		this.groceryName = groceryName;
		this.groceryLocation = groceryLocation;
		this.groceryLatitude = groceryLatitude;
		this.groceryLongitude = groceryLongitude;
		this.groceryDistance = groceryDistance;
	}

	public long getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(long groceryId) {
		this.groceryId = groceryId;
	}

	public String getGroceryName() {
		return groceryName;
	}

	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}

	public String getGroceryLocation() {
		return groceryLocation;
	}

	public void setGroceryLocation(String groceryLocation) {
		this.groceryLocation = groceryLocation;
	}

	public double getGroceryLatitude() {
		return groceryLatitude;
	}

	public void setGroceryLatitude(double groceryLatitude) {
		this.groceryLatitude = groceryLatitude;
	}

	public double getGroceryLongitude() {
		return groceryLongitude;
	}

	public void setGroceryLongitude(double groceryLongitude) {
		this.groceryLongitude = groceryLongitude;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getGroceryDistance() {
		return groceryDistance;
	}

	public void setGroceryDistance(double groceryDistance) {
		this.groceryDistance = groceryDistance;
	}

	@Override
	public int compareTo(Object arg0) {
		
		return 0;
	}

}
