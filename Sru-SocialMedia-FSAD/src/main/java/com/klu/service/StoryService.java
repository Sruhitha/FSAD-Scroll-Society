package com.klu.service;

import java.util.List;

import com.klu.Model.Story;
import com.klu.Model.User;

public interface StoryService {

	public Story createStory(Story story,User user);
	public List<Story> findStoryByUserId(Integer userId) throws Exception;
}
