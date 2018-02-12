package io.zilker.zbuy.factory;

import io.zilker.zbuy.ConcreteClass.Customer;
import io.zilker.zbuy.ConcreteClass.Grocery;
import io.zilker.zbuy.Interface.*;

public class GetOrderFactory {
	
	public OrderInterface fetchOrders(String type) {
		
		if(type.equals("Grocery")) {
			
			return new Grocery();
			
		} else if(type.equals("Customer")) {
			
			return new Customer();
		}
		
		
		return null;
	}

}
