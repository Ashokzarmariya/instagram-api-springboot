package com.zos.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zos.exception.PostException;
import com.zos.exception.UserException;
import com.zos.model.Post;
import com.zos.model.User;
import com.zos.repository.PostRepository;


@Service
public class PostServiceImplementation implements PostService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostRepository postRepo;
	


	
	
	@Override
	public Post createPost(Post post, Integer userId) throws UserException   {
		
		User user = userService.findUserById(userId);
		post.setUser(user);
		
		
			Post createdPost =postRepo.save(post);
			
		
		return createdPost;
	}

	
	@Override
	public List<Post> findPostByUserId(Integer userId) throws UserException {
		
		List<Post> posts=postRepo.findByUserId(userId);
		
		if(posts.size()>0) {
			return posts;
		}
		
		throw new UserException("This user don't have any post");
	}


	@Override
	public Post findePostById(Integer postId) throws PostException {
		Optional<Post> opt = postRepo.findById(postId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new PostException("Post not exist with id: "+postId);
	}


	@Override
	public List<Post> findAllPost() throws PostException {
		List<Post> posts = postRepo.findAll();
		if(posts.size()>0) {
			return posts;
		}
		throw new PostException("Post Not Exist");
	}


	@Override
	public Post likePost(Integer postId, Integer userId) throws UserException, PostException  {
		// TODO Auto-generated method stub
		
		User user= userService.findUserById(userId);
		Post post=findePostById(postId);
		post.getLikedByUsers().add(user);
	
	
		
		return postRepo.save(post);
	}

	@Override
	public Post unLikePost(Integer postId, Integer userId) throws UserException, PostException  {
		// TODO Auto-generated method stub
		
		User user= userService.findUserById(userId);
		Post post=findePostById(postId);
		post.getLikedByUsers().remove(user);
	
	
		
		return postRepo.save(post);
	}

//	@Override
//	public Post likePost(Integer userId, Integer postId)  {
//		// TODO Auto-generated method stub
//		return null;
//	}


//	@Override
//	public Post likePost(Integer userId, Integer postId) throws PostException, UserException {
//		User user=userService.findUserById(userId);
//		Post post=findePostById(postId);
//		
//		post.getLikedByUsers().add(user);
//		
//		return postRepo.save(post);
//		
//	}
	
	

}
