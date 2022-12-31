package com.codeWithdurgesh.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codeWithdurgesh.blog.repository.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void tepoTest() {
		
		String className = this.userRepo.getClass().getName();
		Package packName = this.userRepo.getClass().getPackage();
		System.out.println(className);
		System.out.println(packName);
		
	}
}
//proxy class
//jdk.proxy2.$Proxy101
//package jdk.proxy2
