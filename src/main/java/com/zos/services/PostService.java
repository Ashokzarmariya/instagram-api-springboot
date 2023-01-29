package com.zos.services;

import java.util.List;

import com.zos.exception.PostException;
import com.zos.exception.UserException;
import com.zos.model.Post;
import com.zos.model.User;

public interface PostService {

	public Post createPost(Post post,Integer userId) throws UserException;
	
	public List<Post> findPostByUserId(Integer userId) throws UserException;
	
	public Post findePostById(Integer postId) throws PostException;
	
	public List<Post> findAllPost() throws PostException;
	
//	public Post likePost(Integer postId, Integer userId) throws UserException, PostException;

//	public User likePost(Integer userId, Integer postId) throws UserException, PostException;

	
	
	public Post likePost(Integer postId ,Integer userId) throws UserException, PostException;
	
	public Post unLikePost(Integer postId ,Integer userId) throws UserException, PostException;
	
}
