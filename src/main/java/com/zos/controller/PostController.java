package com.zos.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zos.exception.PostException;
import com.zos.exception.UserException;
import com.zos.model.Post;
import com.zos.services.PostService;
import com.zos.services.UserService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/posts/create/{id}")
	public ResponseEntity<Post> createPostHandler(@RequestBody Post post,@PathVariable("id") Integer userId) throws UserException{
		
		Post createdPost = postService.createPost(post, userId);
		
		return new ResponseEntity<Post>(createdPost,HttpStatus.CREATED);
	}
	
	@GetMapping("/posts/all/{userId}")
	public ResponseEntity<List<Post>> findPostByUserIdHandler(@PathVariable("userId") Integer userId) throws UserException{
		
		List<Post> posts=postService.findPostByUserId(userId);
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	
	@GetMapping("/posts/following/{userIds}")
	public ResponseEntity<List<Post>> findAllPostByUserIds(@PathVariable("userIds") List<Integer> userIds) throws PostException, UserException {
		
		List<Post> posts=postService.findAllPostByUserIds(userIds);
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> findAllPostHandler() throws PostException{
		List<Post> posts=postService.findAllPost();
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws PostException{
		Post post=postService.findePostById(postId);
		
		return new ResponseEntity<Post>(post,HttpStatus.OK);
	}
	
	
	@PutMapping("/posts/like/{userId}")
	public ResponseEntity<Post> likePostHandler(@PathVariable("userId") Integer userId, @RequestBody Post post) throws UserException, PostException{
		Post updatedPost=postService.likePost(post.getId(),userId);
		
		return new ResponseEntity<Post>(updatedPost,HttpStatus.OK);
				
	}
	
	@PutMapping("/posts/unlike/{userId}")
	public ResponseEntity<Post> unLikePostHandler(@PathVariable("userId") Integer userId, @RequestBody Post post) throws UserException, PostException{
		Post updatedPost=postService.unLikePost(post.getId(),userId);
		
		return new ResponseEntity<Post>(updatedPost,HttpStatus.OK);
				
	}
	
	@DeleteMapping("/posts/delete/{postId}/{userId}")
	public ResponseEntity<Post> deletePostHandler(@PathVariable Integer postId, @PathVariable Integer userId) throws UserException, PostException{
		
		Post post=postService.deletePost(postId, userId);
		
		return new ResponseEntity<Post> (post, HttpStatus.OK);
		
	}

}
