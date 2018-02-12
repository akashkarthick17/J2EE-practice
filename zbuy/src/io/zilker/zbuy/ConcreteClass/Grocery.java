package io.zilker.zbuy.ConcreteClass;

import java.util.List;

import io.zilker.zbuy.Interface.OrderInterface;
import io.zilker.zbuy.bean.Orders;
import io.zilker.zbuy.delegate.GroceryDBUtil;

public class Grocery implements OrderInterface {

	@Override
	public List<Orders> fetchOrders(long groceryId) {

		GroceryDBUtil groceryDBUtil = new GroceryDBUtil();

		List<Orders> listOfOrders = groceryDBUtil.fetchListOfOrders(groceryId);

		return listOfOrders;
	}

}
