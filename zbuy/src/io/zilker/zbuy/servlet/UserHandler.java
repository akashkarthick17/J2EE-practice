package io.zilker.zbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.zilker.zbuy.bean.User;
import io.zilker.zbuy.delegate.CustomerDBUtil;

@WebServlet("/UserHandler")
public class UserHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustomerDBUtil customerDelegate;
	User user;

	@Override
	public void init() throws ServletException {
		try {

			customerDelegate = new CustomerDBUtil();

		} catch (Exception e) {
			throw e;
		}
	}

	public UserHandler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set Content Type
		response.setContentType("text/plain");

		int result = 0;

		String redirectPage = "";

		if (request.getParameter("loginOrSignup") != null) {

			if (request.getParameter("loginOrSignup").equals("SIGN UP")) {

				// Get values from parameters
				String email = request.getParameter("email");
				String name = request.getParameter("name");
				long phone = Long.parseLong(request.getParameter("phone"));
				String password = request.getParameter("password");

				// Initialize User Bean Object
				user = new User(email, password, "customer", name, phone, System.nanoTime());

				// Delegate function to register user
				result = customerDelegate.registerUser(user, request, response);

				// On failure
				redirectPage = "signup.jsp";

			} else if (request.getParameter("loginOrSignup").equals("SIGN IN")) {

				// Get values from parameters
				String email = request.getParameter("email");
				String password = request.getParameter("password");

				// Initialize User Bean Object
				user = new User();
				user.setUserEmail(email);
				user.setUserPassword(password);

				result = customerDelegate.loginUser(user, request, response);

				// On failure
				redirectPage = "index.jsp";

			}

			// Response Send Redirect
			if (result == 1) {

				request.getSession().setAttribute("user", user);

				if (user.getUserType().equals("customer")) {
					
					String token = customerDelegate.generateToken("customer", ""+user.getUserId());

					request.getSession().setAttribute("token", token);
					
					response.sendRedirect("customer-login/index.jsp");

				} else if (user.getUserType().equals("grocery")) {

					response.sendRedirect("grocery-login/index.jsp");

				}

			} else {
				response.sendRedirect(redirectPage);
			}

		} else if (request.getParameter("logout") != null) {
			request.getSession().invalidate();

			response.sendRedirect("index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
