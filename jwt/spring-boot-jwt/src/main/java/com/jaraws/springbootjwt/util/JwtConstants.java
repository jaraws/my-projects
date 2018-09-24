package com.jaraws.springbootjwt.util;

public class JwtConstants {

	// Using this key to parse the JWT token
	// We can have multiples secrets/keys for multiple web tokens
	public static final String SECRET = "swaraj";
	
	public static final String CLAIMS_ID = "id";
	public static final String CLAIMS_ROLE = "role";
}
