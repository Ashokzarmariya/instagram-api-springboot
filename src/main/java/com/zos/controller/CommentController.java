package com.zos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zos.exception.CommentException;
import com.zos.exception.PostException;
import com.zos.exception.UserException;
import com.zos.model.Comments;
import com.zos.services.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comments/new/{postId}/{userId}")
	public ResponseEntity<Comments> createCommentHandler(@RequestBody Comments comment, @PathVariable("postId") Integer postId,@PathVariable("userId") Integer userId) throws PostException, UserException{
		
		Comments createdComment = commentService.createComment(comment, postId, userId);
		return new ResponseEntity<Comments>(createdComment,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/comments/like/{userId}")
	public ResponseEntity<Comments> likeCommentHandler(@RequestBody Comments comment, @PathVariable Integer userId) throws UserException, CommentException{
		Comments likedComment=commentService.likeComment(comment.getId(), userId);
		
		return new ResponseEntity<Comments>(likedComment,HttpStatus.OK);
	}
	
	@PutMapping("/comments/unlike/{userId}")
	public ResponseEntity<Comments> unlikeCommentHandler(@RequestBody Comments comment, @PathVariable Integer userId) throws UserException, CommentException{
		Comments likedComment=commentService.unlikeComment(comment.getId(), userId);
		
		return new ResponseEntity<Comments>(likedComment,HttpStatus.OK);
	}
	

}
