package io.zilker.zbuy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.zilker.zbuy.bean.User;
import io.zilker.zbuy.delegate.CustomerDBUtil;

@WebServlet("/CartHandler")
public class CartHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartHandler() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");

		if (request.getParameter("deleteCart") != null) {

			// Get Item Id from the request
			long itemId = Long.parseLong(request.getParameter("itemId"));

			// Get user Id from the session
			User customer = (User) request.getSession().getAttribute("user");
			long customerId = customer.getUserId();

			// pass userid and itemid to delete from the table
			CustomerDBUtil customerDBUtil = new CustomerDBUtil();
			customerDBUtil.deleteCartItem(itemId, customerId);

			int count = 1;

			// Get existing quantity count of the item
			int existingCount = customer.getCartCount();

			updateCartCount(customer, existingCount, count, "delete");

			response.getWriter().append("sucessfully deleted.");

		} else if (request.getParameter("addCart") != null) {

			// Get the item details from the request
			long itemId = Long.parseLong(request.getParameter("itemId"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			User customer = (User) request.getSession().getAttribute("user");
			long customerId = (customer.getUserId());

			CustomerDBUtil customerDBUtil = new CustomerDBUtil();

			// Add the item to the database and return 1 if new Item Added else 0
			int count = customerDBUtil.addToCart(customerId, itemId, quantity);

			// Get existing quantity count of the item
			int existingCount = customer.getCartCount();

			// update the item quantity count
			updateCartCount(customer, existingCount, count, "add");

			// Set the session to access in all customer pages
			request.getSession().setAttribute("user", customer);

			// append to the response
			response.getWriter().append("" + count);

		} else if (request.getParameter("checkoutCart") != null) {

			// Get user Id from the session
			User user = (User) request.getSession().getAttribute("user");
			long userId = user.getUserId();

			CustomerDBUtil customerDBUtil = new CustomerDBUtil();
			customerDBUtil.cartCheckout(userId);

			user.setCartCount(0);

			request.getSession().setAttribute("user", user);

			// success message
			response.getWriter().append("order has been placed");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void updateCartCount(User user, int existingCount, int count, String operationType) {

		int updatedCount;

		if (operationType.equals("add")) {

			updatedCount = count + existingCount;
			user.setCartCount(updatedCount);

		} else {
			updatedCount = existingCount - count;
			user.setCartCount(updatedCount);
		}

	}

}
