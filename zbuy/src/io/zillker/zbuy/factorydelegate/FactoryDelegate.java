package io.zillker.zbuy.factorydelegate;


import io.zilker.zbuy.Interface.OrderInterface;
import io.zilker.zbuy.factory.GetOrderFactory;


public class FactoryDelegate {
		
	public OrderInterface getOrderObject(String userType) {
		
		GetOrderFactory orderFactory = new GetOrderFactory();
		
		OrderInterface orderInterface = orderFactory.fetchOrders(userType);
		
		return orderInterface;
		
	}
	
}
