package io.zilker.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import io.zilker.rest.annotations.*;


@Provider
@Customer
public class CustomerFilter implements ContainerRequestFilter {

	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("in filter");
		
	}

	

}
