package io.zilker.zbuy.bean;

public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String userEmail, userPassword, userType, userName;
	private long userId, userPhone;
	private int cartCount;

	public User() {
		super();
	}

	public User(String userEmail, String userPassword, String userType, String userName, long userPhone, long userId) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
