package io.zilker.rest.oauth;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.TokenResult;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;

import io.zilker.rest.utility.OauthService;

@Path("/oauth-success")
public class OAuthSuccess {

	@GET
	public Response authSuccess(@QueryParam("state") String state, @QueryParam("code") String code) throws URISyntaxException {
		Client  client = ClientBuilder.newClient(); 
		
		System.out.println("State : "+state);
		System.out.print("code : " + code);
		
		OauthService oauthService = new OauthService();
		
		OAuth2CodeGrantFlow flow = oauthService.getFlow();

		
		TokenResult tokenResult = flow.finish(code, state);

			 
		 
		  client.register(LoggingFilter.class); 
		  client.register(OAuth2ClientSupport.feature(tokenResult.getAccessToken())); 
		  System.out.println("token : "+tokenResult.getAccessToken());
		  client.register(JacksonFeature.class); 
		  
	
		return  Response.seeOther(new URI("http://localhost:8080/zbuy")).build();
	}
	
	
	
}
