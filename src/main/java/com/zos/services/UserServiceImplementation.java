package com.zos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zos.exception.UserException;
import com.zos.model.User;
import com.zos.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository repo;

	
	@Override
	public User registerUser(User user) throws UserException {
		
		User isEmailExist = repo.findByEmail(user.getEmail());
		if (isEmailExist!=null) {
			throw new UserException("Email Already Exist");
		}
		User isUsernameTaken=repo.findByUsername(user.getUsername());
		if(isUsernameTaken!=null) {
			throw new UserException("Username Already Taken");
		}
		return repo.save(user);
		
	}

	
	@Override
	public User findUserById(Integer userId) throws UserException {
		
		Optional<User> opt =repo.findById(userId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		throw new UserException("user not found with userid :"+userId);
	}

}
