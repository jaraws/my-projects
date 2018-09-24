package com.jaraws.springbootjwt.security;

import static com.jaraws.springbootjwt.util.JwtConstants.CLAIMS_ID;
import static com.jaraws.springbootjwt.util.JwtConstants.CLAIMS_ROLE;
import static com.jaraws.springbootjwt.util.JwtConstants.SECRET;

import org.springframework.stereotype.Component;

import com.jaraws.springbootjwt.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {


    public String generate(JwtUser jwtUser) {


        Claims claims = Jwts.claims()
                			.setSubject(jwtUser.getUsername());
        claims.put(CLAIMS_ID, String.valueOf(jwtUser.getId()));
        claims.put(CLAIMS_ROLE, jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,SECRET)
                .compact();
    }
}
