package com.zos.services;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zos.exception.StoryException;
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
		story.setTimestamp(LocalDateTime.now());
		return storyRepo.save(story);
		
		
	}

	@Override
	public List<Story> findStoryByUserId(Integer userId) throws UserException,StoryException {
		
		User user = userService.findUserById(userId);
		
		List<Story>  stories = storyRepo.findAllStoriesByUserId(userId);
		
		if(stories.size()==0) {
			throw new StoryException("This user Don't have any Story");
		}
		
		return stories;
	}

}
