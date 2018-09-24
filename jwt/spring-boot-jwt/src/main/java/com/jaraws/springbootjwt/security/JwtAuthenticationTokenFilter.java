package com.jaraws.springbootjwt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.jaraws.springbootjwt.model.JwtAuthenticationToken;

/**
 * Custom filter for JWT authentication
 * 
 * @author SWARAJ
 */
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	public JwtAuthenticationTokenFilter() {
		 super("/rest/**");
	}
	
	/*
	 * It is to proceed with the next filter in the chain that request does not get block
	 */
	@Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);

    }

	/**
	 * Here we will be authenticating the JWT User, basically perform the authentication of received
	 * user details obtained from JWT token.
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		String authHeaderValue = request.getHeader("Authorisation");
		
		if (authHeaderValue == null || !authHeaderValue.startsWith("Token ")) {
            throw new RuntimeException("JWT Token is missing");
        }
		String authenticationToken = authHeaderValue.substring(6);
		
		JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
	}

}
