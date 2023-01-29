package com.zos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zos.exception.UserException;
import com.zos.model.Story;
import com.zos.model.User;
import com.zos.repository.StoryRepository;

@Service
public class StoryServiceImplementation implements StoryService {
	
	@Autowired
	private StoryRepository storyRepo;
	@Autowired
	private UserService userService;

	@Override
	public Story createStory(Story story, Integer userId) throws UserException {
		
		User user = userService.findUserById(userId);
		
		story.setUser(user);
		return storyRepo.save(story);
		
		
	}

}
