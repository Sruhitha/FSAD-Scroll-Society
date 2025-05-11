package com.klu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.Model.Story;
import com.klu.Model.User;
import com.klu.Repository.StoryRepo;

@Service
public class StoryServiceImplmentation implements StoryService{

	@Autowired
	private StoryRepo storyRepo;
	@Autowired
	private UserService userService;
	
	@Override
	public Story createStory(Story story, User user) {
		Story createdStory = new Story();
		createdStory.setCaption(story.getCaption());
		createdStory.setImage(story.getImage());
		createdStory.setUser(user);
		createdStory.setTimestamp(LocalDateTime.now());
				
		return storyRepo.save(createdStory);
	}

	@Override
	public List<Story> findStoryByUserId(Integer userId) throws Exception {
		User user = userService.findUserById(userId);
		return storyRepo.findByUserId(userId);
	}

}
