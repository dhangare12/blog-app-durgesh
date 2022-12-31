package com.codeWithdurgesh.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codeWithdurgesh.blog.entities.User;
import com.codeWithdurgesh.blog.exeptions.ResourceNotFoundException;
import com.codeWithdurgesh.blog.repository.UserRepo;

@Service
public class CostomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//loading  user from database by userName
		
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(()-> new ResourceNotFoundException("User", "email :"+username,0));
		
		
		return user;
	}

}
