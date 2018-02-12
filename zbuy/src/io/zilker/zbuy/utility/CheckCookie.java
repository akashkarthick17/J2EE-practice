package io.zilker.zbuy.utility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCookie {

	public static boolean isCookieAvailable(HttpServletRequest request, String name) {

		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			cookie = cookies[i];

			System.out.println("cookieName: " + cookie.getName());

			if (cookie.getName().equals(name)) {

				return true;
			}

		}

		return false;

	}

	public static void deleteCookies(HttpServletResponse response, Cookie[] cookies) {

		Cookie cookie = null;

		for (int i = 0; i < cookies.length; i++) {

			cookie = cookies[i];

			
			if (cookie.getName().equals("location")) {
				
				System.out.println("deleting cookie.. : " + cookie.getName());


				cookie.setMaxAge(0);
				cookie.setPath("/");

				response.addCookie(cookie);

			}

			
		}

	}

}
