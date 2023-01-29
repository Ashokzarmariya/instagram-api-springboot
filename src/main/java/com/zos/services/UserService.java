package com.zos.services;

import java.util.Optional;

import com.zos.exception.UserException;
import com.zos.model.User;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	public User findUserById(Integer userId) throws UserException;

}
