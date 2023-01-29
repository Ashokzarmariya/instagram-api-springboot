package com.zos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zos.exception.UserException;
import com.zos.model.User;
import com.zos.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users/register")
	public ResponseEntity<User> registerUserHandler(@RequestBody User user) throws UserException{
		
		User createdUser=userService.registerUser(user);
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
	}

}
