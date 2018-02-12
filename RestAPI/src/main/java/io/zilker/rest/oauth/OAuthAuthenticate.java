package io.zilker.rest.oauth;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.TokenResult;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import io.zilker.rest.utility.OauthService;

@Path("/oauth-authentication")
public class OAuthAuthenticate {

	ResourceConfig resourceConfig = new ResourceConfig().register(OauthService.class);

	@GET
	@Path("/authenticate")
	public Response auth(@Context HttpServletRequest request) throws URISyntaxException {

		ClientIdentifier cliendId = new ClientIdentifier(
				"832241168101-45bg94f407u0v2vllh52ik4521ivt7p3.apps.googleusercontent.com", "3vKSqrTUcwdabq-dwwjs0Xmy");

		OAuth2CodeGrantFlow.Builder<?> flowBuilder = OAuth2ClientSupport.authorizationCodeGrantFlowBuilder(cliendId,
				"https://accounts.google.com/o/oauth2/auth", "https://accounts.google.com/o/oauth2/token");
		
		
		OAuth2CodeGrantFlow flow = flowBuilder.scope("https://www.googleapis.com/auth/admin.directory.customer")
				.redirectUri("http://localhost:8080/RestAPI/authenticate/oauth-authentication/success").build();

		String authUrl = flow.start();

		request.getSession().setAttribute("flow", flow);

		return Response.seeOther(new URI(authUrl)).build();
	}

	@GET
	@Path("/success")
	public Response authSuccess(@QueryParam("state") String state, @QueryParam("code") String code,
			@Context HttpServletRequest request) throws URISyntaxException {
		Client client = ClientBuilder.newClient();

		System.out.println("State : " + state);
		System.out.print("code : " + code);

		OAuth2CodeGrantFlow flow = (OAuth2CodeGrantFlow) request.getSession().getAttribute("flow");

		TokenResult tokenResult = flow.finish(code, state);

		client.register(LoggingFilter.class);
		client.register(OAuth2ClientSupport.feature(tokenResult.getAccessToken()));
		System.out.println("token : " + tokenResult.getAccessToken());
		client.register(JacksonFeature.class);

		return Response.seeOther(new URI("http://localhost:8080/zbuy")).build();
	}
}
