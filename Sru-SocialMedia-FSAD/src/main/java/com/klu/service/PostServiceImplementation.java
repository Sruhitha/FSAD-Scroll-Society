package com.klu.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.Model.Post;
import com.klu.Model.User;
import com.klu.Repository.PostRepo;
import com.klu.Repository.UserRepo;

@Service
public class PostServiceImplementation implements PostService{

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public Post createNewPost(Post post, Integer userId) throws Exception {
		// TODO Auto-generated method stub
		User user = userService.findUserById(userId);
		Post newPost = new Post();
		newPost.setCaption(post.getCaption());
		newPost.setImage(post.getImage());
		newPost.setCreatedAt(LocalDateTime.now());
		newPost.setVideo(post.getVideo());
		newPost.setUser(user);
		
		return postRepo.save(newPost);
	}

	@Override
	public String deletePost(Integer postId, Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Post post = findPostById(postId);
		User user = userService.findUserById(userId);
		if(post.getUser().getId()!=user.getId()) {
			throw new Exception("you cant delete another users post");
		}
		postRepo.delete(post);
		return "Post deleted sucessfully";
	}

	@Override
	public Post findPostById(Integer postId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Post> opt = postRepo.findById(postId);
		if(opt.isEmpty()) {
			throw new Exception("post not found with id "+postId);
		}
		return opt.get();
	}

	@Override
	public List<Post> findPostByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return postRepo.findPostByUserId(userId);
	}

	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		return postRepo.findAll();
	}

	@Override
	public Post savedPost(Integer postId, Integer userId) throws Exception {
		Post post = findPostById(postId);
		User user = userService.findUserById(userId);
		if(user.getSavedPost().contains(post)) {
			user.getSavedPost().remove(post);
		}else {
			user.getSavedPost().add(post);
		}
		userRepo.save(user);
		return post;
	}

	@Override
	public Post likePost(Integer postId, Integer userId) throws Exception {
		Post post = findPostById(postId);
		User user = userService.findUserById(userId);
		if(post.getLiked().contains(user)) {
			post.getLiked().remove(user);
		}else {
			post.getLiked().add(user);
		}
		return postRepo.save(post);
	}

}
