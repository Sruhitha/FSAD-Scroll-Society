package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.Model.Reels;
import com.klu.Model.User;
import com.klu.Repository.ReelsRepo;
@Service
public class ReelsServiceImplementation implements ReelsService{

	@Autowired
	private ReelsRepo reelsRepo;
	@Autowired
	private UserService userService;
	@Override
	public Reels createReel(Reels reel, User user) {
		Reels createReel = new Reels();
		createReel.setTitle(reel.getTitle());
		createReel.setVideo(reel.getVideo());
		createReel.setUser(user);
		return reelsRepo.save(createReel);
	}

	@Override
	public List<Reels> findAllReels() {
		// TODO Auto-generated method stub
		
		return reelsRepo.findAll();
	}

	@Override
	public List<Reels> findUsersReel(Integer userId) throws Exception {
		userService.findUserById(userId);
		return reelsRepo.findByUserId(userId);
	}

}
