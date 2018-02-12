package io.zilker.zbuy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.zilker.zbuy.delegate.GroceryDBUtil;

@WebServlet("/GroceryHandler")
public class GroceryHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GroceryHandler() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");

		String requestParameter = request.getParameter("type");

		if (requestParameter != null) {

			if (requestParameter.equals("deliver")) {

				long orderId = Long.parseLong(request.getParameter("OrderId"));

				GroceryDBUtil groceryDBUtil = new GroceryDBUtil();
				groceryDBUtil.deliverOrder(orderId);

			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
