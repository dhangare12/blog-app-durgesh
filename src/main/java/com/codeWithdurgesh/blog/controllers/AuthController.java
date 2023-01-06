package com.codeWithdurgesh.blog.controllers;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithdurgesh.blog.exeptions.ApiException;
import com.codeWithdurgesh.blog.payloads.JwtAuthRequest;
import com.codeWithdurgesh.blog.payloads.JwtAuthResponse;
import com.codeWithdurgesh.blog.payloads.UserDto;
import com.codeWithdurgesh.blog.security.JwtTokenHelper;
import com.codeWithdurgesh.blog.services.UserServiceI;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserServiceI userServiceI;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		this.authenticate(request.getUsername(),request.getPassword());
	
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
	
	String token = this.jwtTokenHelper.generateToken(userDetails);
	
	JwtAuthResponse response =new JwtAuthResponse();
	response.setToken(token);
	return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
	}
	
		private void authenticate(String username, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, password);
		
		try {
		this.authenticationManager.authenticate(authenticationToken);
	}catch(BadCredentialsException e) {
		
		System.out.println("invalid Detials !!");
		
		throw new ApiException("invalid userName and password !! ");
		
		}
	}
		
		//register new  User api
		
		
		@PostMapping("/register")
		public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
			
			UserDto registerUser = this.userServiceI.registerNewUser(userDto);
			
			return  new ResponseEntity<UserDto>(registerUser,HttpStatus.CREATED);
		}
		



}



		

	
	

