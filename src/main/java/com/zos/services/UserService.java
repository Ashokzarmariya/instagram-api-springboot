package com.zos.services;

import java.util.Optional;

import com.zos.dto.UserDto;
import com.zos.exception.UserException;
import com.zos.model.User;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	
	public User findUserById(Integer userId) throws UserException;
	
//	public User findUserByUsername(String username) throws UserException;
	
	public String followUser(Integer reqUserId,Integer followUserId) throws UserException;
	
	public String unfollowUser(Integer reqUserId, Integer unfollowUserId) throws UserException; 
}
