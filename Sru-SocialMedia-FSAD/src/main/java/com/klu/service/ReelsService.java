package com.klu.service;

import java.util.List;


import com.klu.Model.Reels;
import com.klu.Model.User;

public interface ReelsService {

	public Reels createReel(Reels reel,User user);
	public List<Reels> findAllReels();
	public List<Reels> findUsersReel(Integer userId) throws Exception;
}
