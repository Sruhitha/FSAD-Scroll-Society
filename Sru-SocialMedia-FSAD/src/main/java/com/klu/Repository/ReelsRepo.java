package com.klu.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.Model.Reels;

public interface ReelsRepo extends JpaRepository<Reels,Integer>{

	public List<Reels> findByUserId(Integer userId);
}
