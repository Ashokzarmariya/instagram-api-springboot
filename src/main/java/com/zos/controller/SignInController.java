package com.zos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zos.exception.UserException;
import com.zos.model.User;
import com.zos.repository.UserRepository;

@RestController
public class SignInController {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@GetMapping("/signin")
	public ResponseEntity<User> signinHandler(Authentication auth) throws UserException{
		
		Optional<User> opt=userRepo.findByEmail(auth.getName());
		
		if(opt.isPresent()) {
			User user=opt.get();
			return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
		}
		throw new UserException("user not found with email: "+auth.getName());
	
	}

}
