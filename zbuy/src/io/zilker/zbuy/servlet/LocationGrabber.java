package io.zilker.zbuy.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.zilker.zbuy.bean.Grocery;
import io.zilker.zbuy.bean.Items;
import io.zilker.zbuy.delegate.CustomerDBUtil;
import io.zilker.zbuy.utility.CheckCookie;
import io.zilker.zbuy.utility.Locator;

/**
 * Servlet implementation class LocationGrabber
 */
@WebServlet("/LocationGrabber")
public class LocationGrabber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LocationGrabber() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");

		String lat = (request.getParameter("lat"));
		String lng = (request.getParameter("long"));

		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

		System.out.println("Setting Cookies in servlet " + timeStamp);

		// deleting existing cookies
		CheckCookie.deleteCookies(response, request.getCookies());

		// Setting Cookies
		Cookie locationCookie = new Cookie("location", "available");
		locationCookie.setMaxAge(60 * 60);
		response.addCookie(locationCookie);

		// Setting session
		request.getSession().setAttribute("latitude", lat);
		request.getSession().setAttribute("longitude", lng);

		// convert lat and lng to double
		double latitude = Double.parseDouble(lat);
		double longitude = Double.parseDouble(lng);

		System.out.println(latitude + "," + longitude);

		// Get City name from user latitude and longitude
		Locator locator = new Locator();
		String cityName = locator.getCityName(latitude, longitude);

		System.out.print(cityName);

		// Get nearest Grocery Id with respect to latitude and longitude
		CustomerDBUtil customerDBUtil = new CustomerDBUtil();
		List<Grocery> groceryList = customerDBUtil.getNearestGrocery(latitude, longitude, cityName);

		// Store the groceryList in session to access in future
		request.getSession().setAttribute("groceryList", groceryList);

		Grocery grocery = groceryList.get(0);

		// preferred Grocery Shop
		request.getSession().setAttribute("grocery", grocery);

		// Get Products from the preferred shop
		List<Items> itemsList = customerDBUtil.getProductsFromGrocery(grocery);

		// Set items in the session
		request.getSession().setAttribute("groceryItems", itemsList);

		response.sendRedirect("customer-login/index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
