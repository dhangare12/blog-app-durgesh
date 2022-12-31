package com.codeWithdurgesh.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithdurgesh.blog.payloads.ApiResponse;
import com.codeWithdurgesh.blog.payloads.UserDto;
import com.codeWithdurgesh.blog.services.UserServiceI;



@RestController
@RequestMapping("/api/users/")
public class UserController {

	@Autowired
	private UserServiceI userServiceI;
	
	/**
	 * @author JYOTI
	 * @apiNote This is create user
	 * @param userDto
	 * @return
	 */
	//post-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody 	UserDto userDto){
		UserDto createUserDto= this.userServiceI.createUser(userDto);
		
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	/**
	 * @author JYOTI
	 * @apiNote This is update user
	 * @param userDto
	 * @param uid
	 * @return
	 */
	//put-update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
		
		UserDto updatedUser=this.userServiceI.updateUser(userDto, uid);
	return ResponseEntity.ok(updatedUser);
	}
	
	/**
	 * @author JYOTI
	 * @apiNote this is delete user
	 * @param uid
	 * @return
	 */
	
	//delete= delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId")Integer uid){
 this.userServiceI.deleteUser(uid);
 return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
		
	}
	
	/**
	 * @author JYOTI
	 * @apiNote this is get user
	 * @return
	 */
	//get=user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userServiceI.getAllUsers());
		
	}
	
	/**
	 * @author JYOTI
	 * @apiNote this is All get user
	 * @param userId
	 * @return
	 */
	//get all user get
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userServiceI.getUserByid(userId));
		
	}
			
}
