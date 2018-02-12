package io.zilker.rest.demo.RestAPI;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.zilker.rest.repository.CustomerRepository;

@Path("/{userId}/cart")
public class Cart {
	
	@GET
	@Path("/{itemId}")
	@Produces(MediaType.TEXT_HTML)
	public String deleteCreateItem() {

		return "Successfully created";

	}

	@DELETE
	@Path("/{itemId}")
	@Produces(MediaType.TEXT_HTML)
	public String deleteCartItem(@PathParam("userId") long userId, @PathParam("itemId") long itemId) {

		CustomerRepository customerRepository = new CustomerRepository();
		customerRepository.deleteCartItem(itemId, userId);
		
		return "Successfully Deleted "+userId+ " "+itemId;

	}
	
	@POST
	@Path("/{itemId}")
	@Produces(MediaType.TEXT_HTML)
	public String postCartItem(@PathParam("userId") long userId, @PathParam("itemId") long itemId) {

		return "Successfully posted "+userId+ " "+itemId;

	}
	
	

}
