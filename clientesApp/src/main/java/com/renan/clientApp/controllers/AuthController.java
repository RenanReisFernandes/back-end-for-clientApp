package com.renan.clientApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renan.clientApp.Request.AuthRequest;
import com.renan.clientApp.Response.AuthResponse;
import com.renan.clientApp.config.JwtUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	 @Autowired
	    private AuthenticationManager authManager;

	    @Autowired
	    private JwtUtil jwtUtil;

	    @PostMapping("/login")
	    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
	        Authentication authentication = authManager.authenticate(
	                new UsernamePasswordAuthenticationToken(request.username(), request.password())
	        );
	        UserDetails user = (UserDetails) authentication.getPrincipal();
	        String token = jwtUtil.gerarToken(user);
	        return ResponseEntity.ok(new AuthResponse(token));
	    }

}
