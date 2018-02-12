package io.zilker.rest.jwt;


import java.io.UnsupportedEncodingException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Path("/jwt")
public class JWTAuthentication {

	@GET
	@Path("token")
	public String JWTAuthenticate() {
		String token="";
		//HMAC
		try {
			Algorithm algorithm = Algorithm.HMAC256("secret");
			   token = JWT.create()
				        .withIssuer("auth0")
				        .withClaim("admin", true)
				        .sign(algorithm);
			  //System.out.println(token);
		} catch (IllegalArgumentException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DecodedJWT jwtDecode = JWT.decode(token);
		System.out.println(jwtDecode.getSignature());
		
		return token;
	}
	
	@GET
	@Path("verify") 
	public boolean verify(@Context HttpHeaders hh) {
		
		String token = hh.getRequestHeaders().getFirst("token");
		
		System.out.println("Retreived token : "+token);
		
		Boolean result=false;
		Algorithm algorithm;
		try {
			algorithm = Algorithm.HMAC256("secret");
			JWTVerifier verifier =  JWT.require(algorithm).withIssuer("auth0").build();
			DecodedJWT decodeJWT = verifier.verify(token);
			
			System.out.print(decodeJWT.getClaim("admin").asBoolean());
			result = decodeJWT.getClaim("admin").asBoolean();
			
		} catch (IllegalArgumentException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result = false;
		}
		
		
		
		return result;
		
	}
	
	
}
