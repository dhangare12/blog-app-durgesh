package com.codeWithdurgesh.blog.services;

import java.util.List;

import com.codeWithdurgesh.blog.payloads.UserDto;

public interface UserServiceI {

	UserDto registerNewUser(UserDto userDto);
	
	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userid);

	UserDto getUserByid(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);
}
