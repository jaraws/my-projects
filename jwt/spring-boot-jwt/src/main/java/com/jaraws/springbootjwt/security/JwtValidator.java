package com.jaraws.springbootjwt.security;

import static com.jaraws.springbootjwt.util.JwtConstants.CLAIMS_ID;
import static com.jaraws.springbootjwt.util.JwtConstants.CLAIMS_ROLE;
import static com.jaraws.springbootjwt.util.JwtConstants.SECRET;

import org.springframework.stereotype.Component;

import com.jaraws.springbootjwt.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	
	
	public JwtUser validate(String token) {
		
		System.out.println("Received token: "+ token);
		JwtUser jwtUser = null;
		
		try {
			// Break the JsonWebToken into claims
			// Since we are going to parse the token we are using the parser
			Claims claims = Jwts.parser()
								.setSigningKey(SECRET)
									.parseClaimsJws(token)			
										.getBody();
			
			// Extract the username, userId and role from the jwt token and setting it into 
			// custom model called JwtUser and we are returning this model
			jwtUser = new JwtUser();
			jwtUser.setUsername(claims.getSubject());
			jwtUser.setId(Long.parseLong((String) claims.get(CLAIMS_ID)));
			jwtUser.setRole((String)claims.get(CLAIMS_ROLE));
		}catch(Exception e) {
			System.out.println(">>>>>>>>>>>>> "+e.getMessage());
		}
		// return null in case of an exception while retrieving the token information
		return jwtUser;
	}

}
