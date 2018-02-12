package io.zilker.zbuy.ConcreteClass;

import java.util.List;

import io.zilker.zbuy.Interface.OrderInterface;
import io.zilker.zbuy.bean.Orders;
import io.zilker.zbuy.delegate.CustomerDBUtil;

public class Customer implements OrderInterface {

	@Override
	public List<Orders> fetchOrders(long userId) {
		
		CustomerDBUtil customerDBUtil = new CustomerDBUtil();
		
		List<Orders> listOfOrders = customerDBUtil.fetchListOfOrders(userId);
		
		return listOfOrders;
	}

}
