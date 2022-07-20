package com.njc.practice.spring.boot.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.njc.practice.spring.boot.service.JwtUtilService;
import com.njc.practice.spring.boot.service.MyUserDetailsService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtilService jwtUtil;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authenticationHeader = request.getHeader("Authorization");

		String username = null;
		String jwt = null;

		if (authenticationHeader != null && authenticationHeader.startsWith("Bearer ")) {
			jwt = authenticationHeader.substring(7);
			username = jwtUtil.extractUserName(jwt);
		} 
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(username);

			if (jwtUtil.validateToken(jwt, userDetails)) {
// this step will be done automatically by spring security, but we are using jwt so we are doing it manually if the jwt token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
	
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain .doFilter(request, response);

	}

	

}
