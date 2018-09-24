package com.jaraws.springbootjwt.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author SWARAJ
 *
 */
public class JwtUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String username;
	private String token;
	private List<? extends GrantedAuthority> authorities;
	
	
	public JwtUserDetails(long userId, String userName, String token, List<? extends GrantedAuthority> authorities) {
		super();
		this.id = userId;
		this.username = userName;
		this.token = token;
		this.authorities = authorities;
	}
	
	public long getId() {
		return id;
	}


	public String getToken() {
		return token;
	}

	public List<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true; // Setting it to true
	}
	@Override
	public boolean isAccountNonLocked() {
		return true; // Setting it to true
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true; // Setting it to true
	}
	@Override
	public boolean isEnabled() {
		return true; // Setting it to true
	}
}
