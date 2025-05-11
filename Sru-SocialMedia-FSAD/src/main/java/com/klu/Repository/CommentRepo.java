package com.klu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.Model.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer>{

	
}
