package io.zilker.zbuy.delegate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import io.zilker.zbuy.bean.*;
import io.zilker.zbuy.utility.Constants;
import io.zilker.zbuy.utility.DBConnection;

public class GroceryDBUtil {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	DataSource dataSource;
	DBConnection dbConnection;

	public GroceryDBUtil() {
		dbConnection = new DBConnection();
		this.dataSource = dbConnection.getDataSource();
	}

	public List<Items> retrieveAllItems(long groceryId) {

		Items items;
		List<Items> itemsList = new ArrayList<>();

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM ITEMS I, CATEGORIES C WHERE I.GROCERYID=? AND  I.CATEGORYID=C.CATEGORYID");
			preparedStatement.setLong(1, groceryId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				long itemId = resultSet.getLong("ItemId");
				String itemName = resultSet.getString("ItemName");
				double itemPrice = resultSet.getDouble("ItemPrice");
				int quantity = resultSet.getInt("quantity");
				String itemImage = resultSet.getString("ItemImage");
				String units = resultSet.getString("Units");
				long categoryId = resultSet.getLong("CategoryId");
				String categoryName = resultSet.getString("CategoryName");

				items = new Items(itemId, groceryId, categoryId, itemName, itemImage, units, categoryName, itemPrice,
						quantity);

				itemsList.add(items);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return itemsList;
	}

	public List<Orders> fetchListOfOrders(long groceryId) {
		List<Orders> listOfOrders = new ArrayList<>();
		Orders order;

		try {
			// Get connection from the data source
			connection = dataSource.getConnection();

			// fetch the orders
			preparedStatement = connection.prepareStatement(
					"SELECT  O.ORDERID, C.CUSTOMERNAME, C.CUSTOMERID, O.ORDERDATE, SUM(OD.TOTALPRICE) AS AMOUNT, O.STATUS FROM ORDERS O, ORDERDETAILS OD, CUSTOMER C WHERE O.ORDERID = OD.ORDERID AND O.CUSTOMERID = C.CUSTOMERID AND O.GROCERYID=?  GROUP BY O.ORDERID");
			preparedStatement.setLong(1, groceryId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				long orderId = resultSet.getLong("OrderID");
				String orderDate = resultSet.getString("OrderDate");
				long customerId = resultSet.getLong("CustomerId");
				double amount = resultSet.getDouble("amount");
				String customerName = resultSet.getString("CustomerName");
				String status = resultSet.getString("Status");

				order = new Orders(orderId, groceryId, orderDate, customerName, customerId, amount, status);
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

	public List<OrderDetails> getOrderDetails(long orderId) {
		List<OrderDetails> orderDetailsList = new ArrayList<>();

		try {
			connection = dataSource.getConnection();

			// Get order details from the table
			preparedStatement = connection.prepareStatement(
					"SELECT OD.ITEMID, I.ITEMNAME, OD.TOTALPRICE, OD.TOTALQUANTITY FROM ORDERDETAILS OD, ITEMS I WHERE I.ITEMID = OD.ITEMID AND ORDERID = ?");
			preparedStatement.setLong(1, orderId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				long itemId = resultSet.getLong("ItemId");
				String itemName = resultSet.getString("ItemName");
				double totalPrice = resultSet.getDouble("TotalPrice");
				int totalQuantity = resultSet.getInt("TotalQuantity");

				OrderDetails orderDetails = new OrderDetails(itemId, itemName, totalPrice, totalQuantity);

				orderDetailsList.add(orderDetails);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return orderDetailsList;
	}

	public void deliverOrder(long orderId) {

		try {
			// Get connection from the data source
			connection = dataSource.getConnection();

			// Get the supplier Id with lease order count
			preparedStatement = connection
					.prepareStatement("SELECT SUPPLIERID, MIN(CURRENTORDERCOUNT) AS  CURRENTORDERCOUNT FROM SUPPLIER ");

			resultSet = preparedStatement.executeQuery();

			resultSet.next();

			long supplierId = resultSet.getLong("supplierId");
			int currentOrderCount = resultSet.getInt("CurrentOrderCount");

			// Assign supplier id to the order id
			preparedStatement = connection.prepareStatement("INSERT INTO SUPPLIERDELIVERYORDERS VALUES(?,?)");
			preparedStatement.setLong(1, orderId);
			preparedStatement.setLong(2, supplierId);

			preparedStatement.executeUpdate();

			// Update Supplier Order Count
			preparedStatement = connection
					.prepareStatement("UPDATE SUPPLIER SET CURRENTORDERCOUNT = ? WHERE SUPPLIERID = ?");
			preparedStatement.setInt(1, currentOrderCount + 1);
			preparedStatement.setLong(2, supplierId);

			preparedStatement.executeUpdate();

			// Update Order Status
			preparedStatement = connection.prepareStatement("UPDATE ORDERS SET STATUS = ?  WHERE ORDERID = ?");
			preparedStatement.setString(1, Constants.STATUS_PROCESSED);
			preparedStatement.setLong(2, orderId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	public double getTotalAmount(List<OrderDetails> orderDetailsList) {

		double totalAmount = 0;

		for (OrderDetails orderDetails : orderDetailsList) {
			totalAmount += orderDetails.getTotalPrice();
		}

		return totalAmount;

	}

	public String getOrderStatus(long orderId) {

		String status = "";

		try {
			// Get connection from the data source
			connection = dataSource.getConnection();

			// Get Order Status
			preparedStatement = connection.prepareStatement("SELECT STATUS FROM ORDERS WHERE ORDERID=?");
			preparedStatement.setLong(1, orderId);

			resultSet = preparedStatement.executeQuery();

			resultSet.next();

			status = resultSet.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return status;

	}

	public Items fetchItemDetails(long itemId) {

		Items item;

		CustomerDBUtil customerDBUtil = new CustomerDBUtil();
		item = customerDBUtil.getItemDetails(itemId);

		return item;
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
