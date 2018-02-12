package io.zilker.zbuy.delegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import io.zilker.zbuy.bean.CartItems;
import io.zilker.zbuy.bean.Grocery;
import io.zilker.zbuy.bean.Items;
import io.zilker.zbuy.bean.Orders;
import io.zilker.zbuy.bean.User;
import io.zilker.zbuy.utility.Constants;
import io.zilker.zbuy.utility.DBConnection;
import io.zilker.zbuy.utility.DateFormat;
import io.zilker.zbuy.utility.Locator;
import io.zilker.zbuy.utility.PasswordHashing;

public class CustomerDBUtil {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	DataSource dataSource;
	DBConnection dbConnection;

	public CustomerDBUtil() {

		dbConnection = new DBConnection();
		this.dataSource = dbConnection.getDataSource();
	}

	public int registerUser(User user, HttpServletRequest request, HttpServletResponse response) {

		long userId = user.getUserId();
		String userEmail = user.getUserEmail();
		String userName = user.getUserName();
		long userPhone = user.getUserPhone();
		String userPassword = user.getUserPassword();

		int flag = 0;

		// Generate hash Value for user password
		String hashPassword = PasswordHashing.generateHash(userPassword);

		try {

			connection = dataSource.getConnection();

			// Check for User Exists Already
			preparedStatement = connection.prepareStatement("SELECT COUNT(USEREMAIL) FROM USER WHERE USEREMAIL=?");
			preparedStatement.setString(1, userEmail);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();

			int count = resultSet.getInt(1);

			if (count == 0) {

				// Insert into user Table
				preparedStatement = connection.prepareStatement("INSERT INTO USER VALUES (?,?,?,?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setString(2, userEmail);
				preparedStatement.setString(3, hashPassword);
				preparedStatement.setInt(4, 1);
				preparedStatement.executeUpdate();

				// Insert into customer Table
				preparedStatement = connection.prepareStatement("INSERT INTO CUSTOMER VALUES (?,?,?,?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setString(2, userName);
				preparedStatement.setLong(3, userPhone);
				preparedStatement.setString(4, "");
				preparedStatement.executeUpdate();

				flag = 1;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return flag;

	}

	public String getUserType(String email, String password) {

		String userType = null;

		try {
			connection = dataSource.getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT UT.USERTYPENAME FROM USER U, USERTYPE UT WHERE U.USERTYPEID = UT.USERTYPEID AND U.USEREMAIL = ? AND U.PASSWORD = ?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				userType = resultSet.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return userType;
	}

	public int loginUser(User user, HttpServletRequest request, HttpServletResponse response) {

		String userEmail = user.getUserEmail();
		String userPassword = user.getUserPassword();

		int flag = 0;

		try {

			// Get Connection from datasource
			connection = dataSource.getConnection();

			// Get User Type
			preparedStatement = connection
					.prepareStatement("SELECT USERTYPEID FROM USER WHERE USEREMAIL=? AND PASSWORD=?");
			preparedStatement.setString(1, userEmail);
			preparedStatement.setString(2, userPassword);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();

			// Get type id 1 --> Customer , 2 --> Grocery, 3 --> Admin.
			int typeId = resultSet.getInt("usertypeid");

			// If Customer
			if (typeId == 1) {
				preparedStatement = connection.prepareStatement(
						"SELECT COUNT(U.USERID), U.USERID , C.CUSTOMERNAME  FROM USER U , CUSTOMER C WHERE U.USERID = C.CUSTOMERID AND U.USEREMAIL=? AND U.PASSWORD=?");
				preparedStatement.setString(1, userEmail);
				preparedStatement.setString(2, userPassword);
				resultSet = preparedStatement.executeQuery();

				resultSet.next();

				int rowCount = resultSet.getInt(1);

				// if (resultSet.last()) {
				// rowCount = resultSet.getRow();
				// resultSet.beforeFirst();
				// }

				if (rowCount > 0) {
					long userId = resultSet.getLong("userid");
					String userName = resultSet.getString("customername");

					user.setUserId(userId);
					user.setUserName(userName);
					user.setUserType("customer");

					preparedStatement = connection
							.prepareStatement("SELECT COUNT(CUSTOMERID) FROM SHOPPINGCART WHERE CUSTOMERID=?");
					preparedStatement.setLong(1, userId);

					resultSet = preparedStatement.executeQuery();

					resultSet.next();

					// Get Customer Cart Count
					int cartCount = resultSet.getInt(1);

					user.setCartCount(cartCount);

					flag = 1;

				}
			}

			// If Grocery
			else if (typeId == 2) {
				preparedStatement = connection.prepareStatement(
						"SELECT COUNT(U.USERID), U.USERID , G.GROCERYNAME  FROM USER U , GROCERY G WHERE U.USERID = G.GROCERYID AND U.USEREMAIL=? AND U.PASSWORD=?");
				preparedStatement.setString(1, userEmail);
				preparedStatement.setString(2, userPassword);
				resultSet = preparedStatement.executeQuery();

				resultSet.next();

				int rowCount = resultSet.getInt(1);

				// if (resultSet.last()) {
				// rowCount = resultSet.getRow();
				// resultSet.beforeFirst();
				// }

				if (rowCount > 0) {

					long userId = resultSet.getLong("userid");
					String userName = resultSet.getString("groceryname");

					user.setUserId(userId);
					user.setUserName(userName);
					user.setUserType("grocery");

					flag = 1;

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return flag;
	}

	public List<Grocery> getNearestGrocery(double userLatitude, double userLongitude, String cityName) {

		List<Grocery> groceryList = new ArrayList<>();

		try {

			// Get connection from datasource
			connection = dataSource.getConnection();

			// Get Grocery List near by user's City
			preparedStatement = connection.prepareStatement("SELECT * FROM GROCERY WHERE GROCERYLOCATION=?");
			preparedStatement.setString(1, cityName);

			// Store in Result Set
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				// Get Grocery latitude
				double groceryLatitude = resultSet.getDouble("GroceryLatitude");
				double groceryLongitude = resultSet.getDouble("GroceryLongitude");

				// Calculate Grocery Distance
				Locator locator = new Locator();
				int groceryDistance = locator.distanceInKilometers(userLatitude, groceryLatitude, groceryLongitude,
						userLongitude);

				if (groceryDistance <= 10) {

					// Get other Grocery Details
					String groceryName = resultSet.getString("GroceryName");
					long groceryId = resultSet.getLong("groceryId");
					String groceryLocation = resultSet.getString("GroceryLocation");

					Grocery grocery = new Grocery(groceryId, groceryName, groceryLocation, groceryLatitude,
							groceryLongitude, groceryDistance);

					groceryList.add(grocery);

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return groceryList;

	}

	public List<Items> getProductsFromGrocery(Grocery grocery) {
		List<Items> itemsList = new ArrayList<>();

		long groceryId = grocery.getGroceryId();

		try {
			URL url = new URL("http://localhost:8080/RestAPI/webapi/grocery/" + groceryId + "/products");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Accept", "application/json");

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String temp = "";
			String jsonString = "";

			while ((temp = bufferedReader.readLine()) != null) {

				jsonString += temp;

			}

			JSONObject listOfItem = new JSONObject(jsonString);

			JSONArray itemArray = (JSONArray) listOfItem.get("itemList");

			String itemString = itemArray.toString();

			Gson gson = new Gson();
			itemsList = gson.fromJson(itemString, new TypeToken<List<Items>>() {
			}.getType());

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// GroceryDBUtil groceryDBUtil = new GroceryDBUtil();
		// itemsList = groceryDBUtil.retrieveAllItems(groceryId);

		return itemsList;
	}

	public Items getItemDetails(long itemId) {

		Items item = null;

		try {

			// Get connection from datasource
			connection = dataSource.getConnection();

			// Get Item details from itemId
			preparedStatement = connection.prepareStatement("SELECT * FROM ITEMS WHERE ITEMID = ?");
			preparedStatement.setLong(1, itemId);

			// Store details in resultset
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String itemName = resultSet.getString("ItemName");
				double itemPrice = resultSet.getDouble("ItemPrice");
				int quantity = resultSet.getInt("Quantity");
				String itemImage = resultSet.getString("ItemImage");
				String itemDescription = resultSet.getString("ItemDescription");
				String ingredients = resultSet.getString("Ingredients");
				long categoryId = resultSet.getLong("CategoryId");
				String units = resultSet.getString("Units");
				long groceryId = resultSet.getLong("GroceryId");
				String categoryName = "";

				item = new Items(itemId, groceryId, categoryId, itemName, itemImage, units, categoryName,
						itemDescription, ingredients, itemPrice, quantity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return item;
	}

	public int addToCart(long customerId, long itemId, int quantity) {

		int totalItems = 0;

		try {

			// Get connection from datasource
			connection = dataSource.getConnection();

			// check if item is already present
			preparedStatement = connection.prepareStatement(
					"SELECT COUNT(CUSTOMERID), quantity FROM SHOPPINGCART WHERE CUSTOMERID =? AND ITEMID = ?");
			preparedStatement.setLong(1, customerId);
			preparedStatement.setLong(2, itemId);

			// store result in resultset
			resultSet = preparedStatement.executeQuery();

			resultSet.next();

			int customerCount = resultSet.getInt(1);

			if (customerCount > 0) {

				// Customerid exists ... Update the quantity value
				// Get the existing quantity value.
				int existingQuantity = resultSet.getInt(2);

				// Update the Quantity Value
				int updatedQuantity = existingQuantity + quantity;

				// Update in the table
				preparedStatement = connection
						.prepareStatement("UPDATE SHOPPINGCART SET QUANTITY = ? WHERE CUSTOMERID = ? AND ITEMID = ?");
				preparedStatement.setLong(2, customerId);
				preparedStatement.setInt(1, updatedQuantity);
				preparedStatement.setLong(3, itemId);

				preparedStatement.executeUpdate();

				totalItems = 0;

			} else {

				// CustomerId doesn't Exist ... Insert the item into the table
				preparedStatement = connection.prepareStatement("INSERT INTO SHOPPINGCART VALUES(?,?,?)");
				preparedStatement.setLong(1, customerId);
				preparedStatement.setLong(2, itemId);
				preparedStatement.setInt(3, quantity);

				preparedStatement.executeUpdate();

				totalItems = 1;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return totalItems;
	}

	public List<CartItems> fetchCartItems(long userId) {
		List<CartItems> cartList = new ArrayList<>();
		CartItems cartItems;

		try {

			// Get Connection from the data source....
			connection = dataSource.getConnection();

			// Fetch Cart Items with respect to the user id
			preparedStatement = connection.prepareStatement(
					"SELECT S.ITEMID,S.QUANTITY AS TOTALQUANTITY, I.GROCERYID, G.GROCERYNAME , I.ITEMNAME, I.ITEMPRICE, I.QUANTITY,I.ITEMIMAGE,I.CATEGORYID FROM SHOPPINGCART S, GROCERY G, ITEMS  I WHERE  S.ITEMID = I.ITEMID AND I.GROCERYID = G.GROCERYID AND S.CUSTOMERID = ?");
			preparedStatement.setLong(1, userId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				long itemId = resultSet.getLong("ItemId");
				int totalQuantity = resultSet.getInt("TotalQuantity");
				String itemName = resultSet.getString("ItemName");
				long groceryId = resultSet.getLong("GroceryId");
				double itemPrice = resultSet.getDouble("ItemPrice");
				int quantity = resultSet.getInt("quantity");
				String itemImage = resultSet.getString("ItemImage");
				long categoryId = resultSet.getLong("CategoryId");
				String groceryName = resultSet.getString("GroceryName");

				double totalPrice = totalQuantity * itemPrice;

				cartItems = new CartItems(itemId, categoryId, groceryId, itemName, itemImage, itemPrice, totalPrice,
						quantity, totalQuantity, groceryName);

				cartList.add(cartItems);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return cartList;
	}

	/*
	 * public void deleteCartItem(long itemId, long userId) { try { // Get
	 * connection from the data source connection = dataSource.getConnection();
	 * 
	 * // delete the cart item from the table preparedStatement = connection
	 * .prepareStatement("DELETE FROM SHOPPINGCART WHERE CUSTOMERID = ? AND ITEMID= ?"
	 * ); preparedStatement.setLong(1, userId); preparedStatement.setLong(2,
	 * itemId);
	 * 
	 * // execute the statement preparedStatement.executeUpdate();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } catch (Exception e) {
	 * e.printStackTrace(); } finally { closeConnection(); } }
	 */
	public void deleteCartItem(long itemId, long userId) {

		try {

			URL url = new URL("http://localhost:8080/RestAPI/webapi/" + userId + "/cart/" + itemId);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("DELETE");

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpURLConnection.getInputStream()));
			String temp = "";
			String jsonString = "";

			while ((temp = bufferedReader.readLine()) != null) {

				jsonString += temp;

			}

			System.out.println(jsonString);

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cartCheckout(long userId) {

		List<Long> groceryIdList = new ArrayList<>();

		try {

			// Get connection from the data source...
			connection = dataSource.getConnection();

			// Select distinct grocery id from the cart
			preparedStatement = connection.prepareStatement(
					"SELECT DISTINCT(I.GROCERYID) FROM SHOPPINGCART S, ITEMS I WHERE S.ITEMID = I.ITEMID AND S.CUSTOMERID=?");
			preparedStatement.setLong(1, userId);

			resultSet = preparedStatement.executeQuery();

			// Add grocery Id to the list
			while (resultSet.next()) {
				groceryIdList.add(resultSet.getLong(1));
			}

			for (long groceryId : groceryIdList) {

				// Generate unique Order Id for each grocery Id
				long orderId = userId + groceryId + System.nanoTime();
				String currentDate = DateFormat.getCurrentFormattedDate();

				// Insert into order table
				preparedStatement = connection.prepareStatement("INSERT INTO ORDERS VALUES(?,?,?,?,?)");
				preparedStatement.setLong(1, orderId);
				preparedStatement.setString(2, currentDate);
				preparedStatement.setLong(3, userId);
				preparedStatement.setLong(4, groceryId);
				preparedStatement.setString(5, Constants.STATUS_PENDING);

				preparedStatement.executeUpdate();

				// Get item details from the cart based on individual grocery id
				preparedStatement = connection.prepareStatement(
						"SELECT S.ITEMID, S.QUANTITY AS TOTALQUANTITY , I.ITEMPRICE*S.QUANTITY  AS TOTALPRICE FROM SHOPPINGCART S, ITEMS I WHERE S.ITEMID = I.ITEMID AND I.GROCERYID=? AND CUSTOMERID = ?");
				preparedStatement.setLong(1, groceryId);
				preparedStatement.setLong(2, userId);

				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {

					long itemId = resultSet.getLong("ItemId");
					int totalQuantity = resultSet.getInt("TotalQuantity");
					double totalPrice = resultSet.getDouble("TotalPrice");

					PreparedStatement preparedStatement1 = connection
							.prepareStatement("INSERT INTO ORDERDETAILS VALUES(?,?,?,?)");
					preparedStatement1.setLong(1, orderId);
					preparedStatement1.setLong(2, itemId);
					preparedStatement1.setDouble(3, totalPrice);
					preparedStatement1.setInt(4, totalQuantity);

					// Insert into order details table
					preparedStatement1.executeUpdate();

					// Close the prepared Statement
					preparedStatement1.close();
				}

			}

			// Delete from shopping cart
			preparedStatement = connection.prepareStatement("DELETE FROM SHOPPINGCART WHERE CUSTOMERID=?");
			preparedStatement.setLong(1, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public List<Orders> fetchListOfOrders(long userId) {
		List<Orders> listOfOrders = new ArrayList<>();
		Orders order;

		try {
			// Get connection from the data source
			connection = dataSource.getConnection();

			// fetch the orders
			preparedStatement = connection.prepareStatement(
					"SELECT  O.ORDERID, G.GROCERYNAME, C.CUSTOMERNAME, C.CUSTOMERID, O.ORDERDATE, SUM(OD.TOTALPRICE) AS AMOUNT, O.STATUS FROM ORDERS O, ORDERDETAILS OD, CUSTOMER C, GROCERY G WHERE O.ORDERID = OD.ORDERID AND O.GROCERYID = G.GROCERYID AND O.CUSTOMERID = C.CUSTOMERID AND O.CUSTOMERID=?  GROUP BY O.ORDERID");
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				long orderId = resultSet.getLong("OrderID");
				String orderDate = resultSet.getString("OrderDate");
				double amount = resultSet.getDouble("amount");
				String customerName = resultSet.getString("CustomerName");
				String status = resultSet.getString("Status");
				String groceryName = resultSet.getString("GroceryName");

				order = new Orders(orderId, orderDate, customerName, amount, status, groceryName);
				listOfOrders.add(order);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return listOfOrders;
	}
	
	
	public String generateToken(String role,String userId) {
		
		return null;
		
	}

	public void closeConnection() {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}