package com.zos.services;

import com.zos.exception.UserException;
import com.zos.model.Story;

public interface StoryService {

	public Story createStory(Story story,Integer userId) throws UserException;
}
