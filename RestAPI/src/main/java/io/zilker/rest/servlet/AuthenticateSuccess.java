package io.zilker.rest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.TokenResult;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;

import io.zilker.rest.utility.OauthService;

/**
 * Servlet implementation class AuthenticateSuccess
 */
public class AuthenticateSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Client  client = ClientBuilder.newClient(); 
		
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		//OauthService oauthService = new OauthService();
		
		OAuth2CodeGrantFlow flow = (OAuth2CodeGrantFlow) request.getSession().getAttribute("flow");
	
		
		 TokenResult tokenResult = flow.finish(code, state);
			 
		 
		  client.register(LoggingFilter.class); 
		  client.register(OAuth2ClientSupport.feature(tokenResult.getAccessToken())); 
		  System.out.println("token : "+tokenResult.getAccessToken());
		  client.register(JacksonFeature.class); 
		  
		  response.sendRedirect("http://localhost:8080/zbuy/grocery-login/index.jsp");
		
		 
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
