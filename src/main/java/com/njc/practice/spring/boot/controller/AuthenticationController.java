package com.njc.practice.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njc.practice.spring.boot.model.AuthenticationRequest;
import com.njc.practice.spring.boot.model.AuthenticationResponse;
import com.njc.practice.spring.boot.service.JwtUtilService;
import com.njc.practice.spring.boot.service.MyUserDetailsService;


@RestController
@RequestMapping("/njc")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtilService jwtUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), 
							  authenticationRequest.getPassword()));
		} catch(BadCredentialsException exp) {
			throw new Exception("Incorrect UserName and Password", exp);
		}
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(token));
	}

	

}