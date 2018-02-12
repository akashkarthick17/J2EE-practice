package io.zilker.zbuy.Interface;

import java.util.*;

import io.zilker.zbuy.bean.Orders;

public interface OrderInterface {
	public List<Orders> fetchOrders(long id);
}
