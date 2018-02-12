package io.zilker.rest.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import io.zilker.rest.utility.DBConnection;
import io.zilker.rest.bean.Items;
import java.sql.*;

public class CustomerRepository {

	private DataSource dataSource;
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public CustomerRepository() {

		DBConnection dbConnection = new DBConnection();
		dataSource = dbConnection.getDataSource();
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

	public void deleteCartItem(long itemId, long userId) {
		try {
			// Get connection from the data source
			connection = dataSource.getConnection();

			// delete the cart item from the table
			preparedStatement = connection
					.prepareStatement("DELETE FROM SHOPPINGCART WHERE CUSTOMERID = ? AND ITEMID= ?");
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, itemId);

			// execute the statement
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
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
