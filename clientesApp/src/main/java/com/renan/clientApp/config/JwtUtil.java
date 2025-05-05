package com.renan.clientApp.config;

import java.sql.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private String secret = "chave-secreta";

	public String gerarToken(UserDetails userDetails) {
	    
	    long expirationTime = System.currentTimeMillis() + 86400000; 

	    return Jwts.builder()
	            .setSubject(userDetails.getUsername())
	            .setIssuedAt(new Date(expirationTime)) 
	            .setExpiration(new Date(expirationTime))
	            .signWith(SignatureAlgorithm.HS256, secret)
	            .compact();
	}

    public String extrairUsername(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validarToken(String token, UserDetails userDetails) {
        String username = extrairUsername(token);
        return username.equals(userDetails.getUsername());
    }
}
