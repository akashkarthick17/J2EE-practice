package io.zilker.rest.demo.RestAPI;

import java.util.List;

import javax.ws.rs.*;

import io.zilker.rest.annotations.*;
import io.zilker.rest.bean.ItemList;
import io.zilker.rest.bean.Items;
import io.zilker.rest.repository.CustomerRepository;

@Path("/grocery")
public class Products {

	CustomerRepository customerRepository;

	@GET
	@Path("/{groceryId}/products")
	@Customer
	//@Produces(MediaType.APPLICATION_JSON)
	public ItemList getItemList(@PathParam("groceryId") long groceryId) {

		System.out.println("in products");
		customerRepository = new CustomerRepository();

		List<Items> items = customerRepository.retrieveAllItems(groceryId);

		ItemList itemList = new ItemList();
		itemList.setItemList(items);

		return itemList;
	}

}
