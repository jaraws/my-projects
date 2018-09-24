package com.jaraws.springbootjwt.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * This is the token class which will be used
 * as a model by other classes as token model
 * 
 * @author SWARAJ
 *
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{

	private static final long serialVersionUID = 1L;
	
	private String token;

	public JwtAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
