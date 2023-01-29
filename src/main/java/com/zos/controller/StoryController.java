package com.zos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zos.exception.UserException;
import com.zos.model.Story;
import com.zos.services.StoryService;

@RestController
public class StoryController {
	
	@Autowired
	private StoryService storyService;
	
	
	@PostMapping("/stories/create/{userId}")
	public ResponseEntity<Story> createStoryHandler(@RequestBody Story story, @PathVariable Integer userId) throws UserException{
		
		Story createdStory =storyService.createStory(story, userId);
		return new ResponseEntity<Story>(createdStory,HttpStatus.OK);
	}

}
