package io.zilker.rest.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
//import org.glassfish.jersey.client.oauth2.TokenResult;
//import org.glassfish.jersey.filter.LoggingFilter;
//import org.glassfish.jersey.jackson.JacksonFeature;

import io.zilker.rest.utility.OauthService;

/**
 * Servlet implementation class AuthenticateLogin
 */
public class AuthenticateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Client  client = ClientBuilder.newClient(); 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		 ClientIdentifier cliendId = new ClientIdentifier("832241168101-45bg94f407u0v2vllh52ik4521ivt7p3.apps.googleusercontent.com","3vKSqrTUcwdabq-dwwjs0Xmy"); 
		   
		 OAuth2CodeGrantFlow.Builder<?> flowBuilder = OAuth2ClientSupport.authorizationCodeGrantFlowBuilder(cliendId, "https://accounts.google.com/o/oauth2/auth", "https://accounts.google.com/o/oauth2/token"); 
		 OAuth2CodeGrantFlow flow = flowBuilder.scope("https://www.googleapis.com/auth/admin.directory.customer").redirectUri("http://localhost:8080/RestAPI/AuthenticateSuccess").build(); 
		  String authUrl = flow.start(); 
		  
		  OauthService oauthService = new OauthService();
		  
		  oauthService.setFlow(flow);
		  
		  request.getSession().setAttribute("flow", flow);
		  
		  response.sendRedirect(authUrl);
		  
//		  System.out.println("auth url : "+authUrl);
//		   
//		  Map<String, String> map = null;
//		try {
//			map = retrieveCode(authUrl);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		  String code = map.get("code"); 
//		  String state = map.get("state");  
//		   
//		  TokenResult tokenResult = flow.finish(code, state);
//		 
//		 
//		  client.register(LoggingFilter.class); 
//		  client.register(OAuth2ClientSupport.feature(tokenResult.getAccessToken())); 
//		  System.out.println(tokenResult.getAccessToken());
//		  client.register(JacksonFeature.class); 
//		  Invocation.Builder builder = client.target("http://localhost:8080/RestAPI/webapi/students").request(); 
//		  Response responses = builder.get(); 
//		  
//		  System.out.println(responses);
//		   

		  
		 } 
		 
		 protected Map<String, String> retrieveCode(String authUrl) throws UnsupportedEncodingException { 
			 
			 if(client==null) {
				 System.out.println("client null");
			 }
			 
		  Invocation.Builder request = client.target(authUrl).request(); 
		  
		  System.out.println("request : "+request);
		  
		  Response response = request.get();
		  
		  System.out.println("response : "+response);
		  
		  String[] arr = response.toString().split(",");
		  String code = arr[2].split("=")[1];
		  
		 System.out.println("code : "+code);
		  String[] url = arr[1].split("&");
		  
		
		  
		  String state = url[3].split("=")[1];
		  
		  System.out.println("State : "+state);
		  
		  
		  String location =  "state="+state+"&code="+code; 
		  System.out.println("URI : "+location);
		  return splitQuery(location); 
		 } 
		  
		 protected static Map<String, String> splitQuery(String query) throws UnsupportedEncodingException { 
		     Map<String, String> query_pairs = new LinkedHashMap<String, String>(); 
		     String[] pairs = query.split("&"); 
		     for (String pair : pairs) { 
		         int idx = pair.indexOf("="); 
		         query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8")); 
		     } 
		     return query_pairs; 
		 }  

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
