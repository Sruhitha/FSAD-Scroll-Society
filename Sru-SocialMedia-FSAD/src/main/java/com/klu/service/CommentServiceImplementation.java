package com.klu.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.Model.Comment;
import com.klu.Model.Post;
import com.klu.Model.User;
import com.klu.Repository.CommentRepo;
import com.klu.Repository.PostRepo;

@Service
public class CommentServiceImplementation implements CommentService{

	@Autowired
	PostService postService;
	@Autowired
	UserService userService;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private PostRepo postRepo;
	
	@Override
	public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception {
		User user = userService.findUserById(userId);
		Post post = postService.findPostById(postId);
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreatedAT(LocalDateTime.now());
		Comment savedComment = commentRepo.save(comment);
		post.getComments().add(savedComment);
		postRepo.save(post);
		return savedComment;
	}

	@Override
	public Comment likeComment(Integer commentId, Integer userId) throws Exception {
		Comment comment = findCommentById(commentId);
		User user = userService.findUserById(userId);
		if(!comment.getLiked().contains(user)) {
			comment.getLiked().add(user);
		}else {
			comment.getLiked().remove(user);
		}
		return commentRepo.save(comment);
	}

	@Override
	public Comment findCommentById(Integer commentId) throws Exception {
		Optional<Comment> opt = commentRepo.findById(commentId);
		if(opt.isEmpty()) {
			throw new Exception("Comment not exist");
		}
		
		return opt.get();
	}

}
