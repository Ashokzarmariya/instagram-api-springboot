package com.zos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zos.exception.UserException;
import com.zos.model.User;
import com.zos.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/signup")
	public ResponseEntity<User> registerUserHandler(@RequestBody User user) throws UserException{
		

		
		User createdUser=userService.registerUser(user);

		System.out.println("createdUser --- "+createdUser);
		
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findUserByIdHandler(@PathVariable Integer id) throws UserException{
		User user=userService.findUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PutMapping("/users/follow/{followUserId}")
	public ResponseEntity<String> followUserHandler(@RequestBody User reqUser, @PathVariable Integer followUserId) throws UserException{
		String message=userService.followUser(reqUser.getId(), followUserId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping("/users/unfollow/{unfollowUserId}")
	public ResponseEntity<String> unfollowUserHandler(@RequestBody User reqUser, @PathVariable Integer unfollowUserId) throws UserException{
		String message=userService.unfollowUser(reqUser.getId(), unfollowUserId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}

}
