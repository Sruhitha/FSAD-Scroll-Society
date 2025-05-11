package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.klu.Model.Story;
import com.klu.Model.User;
import com.klu.service.StoryService;
import com.klu.service.UserService;

@RestController
public class StoryController {
	@Autowired
	private StoryService storyService;
	@Autowired
	UserService userService;
	
	@PostMapping("/api/story")
	public Story createStory(@RequestBody Story story,@RequestHeader("Authorization")String jwt) {
		User reqUser = userService.findUserByJWT(jwt);
		Story createdStory = storyService.createStory(story, reqUser);
	
		return createdStory;
		
	}

	@GetMapping("/api/story/user/{userId}")
	public List<Story> findUerStory(@PathVariable Integer userId,@RequestHeader("Authorization")String jwt) throws Exception {
		User reqUser = userService.findUserByJWT(jwt);
		List<Story> createdStory = storyService.findStoryByUserId(userId);
	
		return createdStory;
		
	}
}
