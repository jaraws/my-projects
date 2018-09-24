package com.jaraws.springbootjwt.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.jaraws.springbootjwt.model.JwtAuthenticationToken;
import com.jaraws.springbootjwt.model.JwtUser;
import com.jaraws.springbootjwt.model.JwtUserDetails;

/**
 * This is where we authenticate the request and all the major
 * processing takes place.
 * 
 * @author SWARAJ
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{

	@Autowired
	private JwtValidator jwtValidator;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken)authentication;
		String token = jwtAuthenticationToken.getToken();
		// Now we need to validate the token if it is correct or not, for validating
		// the token we will use a validator
		JwtUser jwtUser = jwtValidator.validate(token);
		
		// Checking if we have successfully decoded the jwt user details out of jwt token
		if(null == jwtUser) {
			throw new RuntimeException("JWT token is not correct");
		}
		// From the decoded jwt user we have obtained the grants for this user
		List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		
		// Now returning the spring user_details which will be used for authentication
		return new JwtUserDetails(jwtUser.getId(),jwtUser.getUsername(),token,authorities);
	}
	

	/*
	 * Returns true if this AuthenticationProvider supports the indicated authentication object i.e
	 * if this authentication provider can authenticate the received authentication token
	 * 
	 */
	@Override
	public boolean supports(Class<?> authenticationToken) {
		// this returns true if JwtAuthenticationToken is either super class 
		// or super interface of class represented by authenticationToken 
		return JwtAuthenticationToken.class.isAssignableFrom(authenticationToken);
	}
}
