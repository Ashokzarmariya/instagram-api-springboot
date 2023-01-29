package com.zos.services;

import com.zos.exception.PostException;
import com.zos.exception.UserException;
import com.zos.model.Comments;

public interface CommentService {
	
	public Comments createComment(Comments comment,Integer postId,Integer userId) throws PostException, UserException;

}
