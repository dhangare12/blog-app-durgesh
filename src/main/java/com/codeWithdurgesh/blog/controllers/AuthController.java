package com.codeWithdurgesh.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithdurgesh.blog.payloads.JwtAuthRequest;
import com.codeWithdurgesh.blog.payloads.JwtAuthResponse;
import com.codeWithdurgesh.blog.security.JwtTokenHelper;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
//	@PostMapping("/login")
//	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request){
//		this.authenticate(request.getUsername(),request.getPassword());
//	}
//
//	private void authenticate(String username, String password) {
//		
//		UsernamePasswordAuthenticationToken AuthenticationToken=new UsernamePasswordAuthenticationToken(username, password);
//		try {
//		this.authenticationManager.authenticate(AuthenticationToken);
//	}catch(DisabledException e) {
//		throw
//	}
//		}
}
