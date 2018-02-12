package io.zilker.rest.utility;

import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;

public class OauthService {
	
	private OAuth2CodeGrantFlow flow;

	public OAuth2CodeGrantFlow getFlow() {
		return flow;
	}

	public void setFlow(OAuth2CodeGrantFlow flow) {
		this.flow = flow;
	}
	
	

}
