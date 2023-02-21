package com.zos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zos.dto.UserDto;
import com.zos.exception.UserException;
import com.zos.model.Post;
import com.zos.model.User;
import com.zos.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User registerUser(User user) throws UserException {
		
		System.out.println("registered user ------ ");
		
		Optional<User> isEmailExist = repo.findByEmail(user.getEmail());
		
		if (isEmailExist.isPresent()) {
			throw new UserException("Email Already Exist");
		}
		
		Optional<User> isUsernameTaken=repo.findByUsername(user.getUsername());
		
		if(isUsernameTaken.isPresent()) {
			throw new UserException("Username Already Taken");
		}
		
		if(user.getEmail()== null || user.getPassword()== null || user.getUsername()==null) {
			throw new UserException("email,password and username are required");
			
		}
		
		String encodedPassword=passwordEncoder.encode(user.getPassword());
		
		User newUser=new User();
		
		newUser.setEmail(user.getEmail());
		newUser.setPassword(encodedPassword);
		newUser.setUsername(user.getUsername());
		
		return repo.save(newUser);
		
	}

	
	@Override
	public User findUserById(Integer userId) throws UserException {
		
		Optional<User> opt =repo.findById(userId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		throw new UserException("user not found with userid :"+userId);
	}
	
	


	@Override
	public String followUser(Integer reqUserId, Integer followUserId) throws UserException {
		User followUser=findUserById(followUserId);
		User reqUser=findUserById(reqUserId);
		
		UserDto follower=new UserDto();
		follower.setEmail(reqUser.getEmail());
		follower.setUsername(reqUser.getUsername());
		follower.setId(reqUser.getId());
		
	
		UserDto following=new UserDto();
		following.setEmail(followUser.getEmail());
		following.setUsername(followUser.getUsername());
		following.setId(followUser.getId());
		
		
		followUser.getFollower().add(follower);
		reqUser.getFollowing().add(following);
		
		repo.save(followUser);
		repo.save(reqUser);
		
		return "you are following "+followUser.getUsername();
	}


	@Override
	public String unfollowUser(Integer reqUserId, Integer unfollowUserId) throws UserException {

		
		User unfollowUser=findUserById(unfollowUserId);
		
		System.out.println("unfollow user ---- "+unfollowUser.toString());
		System.out.println("unfollow user's follower"+unfollowUser.getFollower().toString());
		
		User reqUser=findUserById(reqUserId);
		
		UserDto unfollow=new UserDto();
		unfollow.setEmail(reqUser.getEmail());
		unfollow.setUsername(reqUser.getUsername());
		unfollow.setId(reqUser.getId());
		
	System.out.println("req user --- "+unfollow.toString()==unfollowUser.getFollower().toString());
		UserDto following=new UserDto();
		following.setEmail(unfollowUser.getEmail());
		following.setUsername(unfollowUser.getUsername());
		following.setId(unfollowUser.getId());
		
		
		unfollowUser.getFollower().remove(unfollow);

		repo.save(reqUser);
		
//		User user= userService.findUserById(userId);
//		UserDto userDto=new UserDto();
//		
//		userDto.setEmail(user.getEmail());
//		userDto.setUsername(user.getUsername());
//		userDto.setId(user.getId());
//		
//		Post post=findePostById(postId);
//		post.getLikedByUsers().remove(userDto);
		
		return "you have unfollow "+unfollowUser.getUsername();
		

	}

}
