package com.klu.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.Model.Story;

public interface StoryRepo extends JpaRepository<Story,Integer>{

	public List<Story> findByUserId(Integer userId);
}
