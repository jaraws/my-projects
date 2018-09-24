package com.jaraws.springbootjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jaraws.springbootjwt.model.JwtUser;
import com.jaraws.springbootjwt.security.JwtGenerator;

/**
 * 
 * @author SWARAJ
 *
 */
@RestController
public class JwtTokenGeneratorController {

	@Autowired
	private JwtGenerator jwtGenerator;
	
	@PostMapping("/token")
	public String generateToken(@RequestBody final JwtUser jwtUser) {
		
		System.out.println("Received payload: "+ jwtUser);
		
		String generatedToken =  jwtGenerator.generate(jwtUser);
		System.out.println("Generating token: "+ generatedToken);
		return generatedToken;
	}
}
