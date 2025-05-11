package com.klu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.Model.User;
import com.klu.Repository.UserRepo;
import com.klu.config.JwtProvider;
import com.klu.exceptions.UserException;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setId(user.getId());
		
		User savedUser = userRepo.save(newUser);
		return savedUser;
	}

	@Override
	public User findUserById(Integer userId) throws UserException {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		throw new UserException("User Not Exist with userId "+userId);
	}

	@Override
	public User findUserByEmail(String email) {
		User user = userRepo.findByEmail(email);
		return user;
	}

	@Override
	public User followUser(Integer reqUserId, Integer userId2) throws UserException {
		User reqUser = findUserById(reqUserId);
		User user2 = findUserById(userId2);
		user2.getFollowers().add(reqUser.getId());
		reqUser.getFollowings().add(user2.getId());
		userRepo.save(reqUser);
		userRepo.save(user2);
		return reqUser;
	}

	@Override
	public User updateUser(User user,Integer userId) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> user1 = userRepo.findById(userId);
		if(user1.isEmpty()) {
			throw new UserException("User Not Exist with userId"+userId);
		}
		User oldUser = user1.get();
		if(user.getFirstName()!=null) {
			oldUser.setLastName(user.getLastName());
		}
		if(user.getLastName()!=null) {
			oldUser.setLastName(user.getLastName());
		}
		if(user.getEmail()!=null) {
			oldUser.setEmail(user.getEmail());
		}
		if(user.getGender()!=null) {
			oldUser.setGender(user.getGender());
		}
		
		User updatedUser = userRepo.save(oldUser);
		return updatedUser;
	}

	@Override
	public List<User> searchUser(String query) {
		
		return userRepo.searchUser(query);
	}

	@Override
	public User findUserByJWT(String jwt) {
		// TODO Auto-generated method stub
		String email = JwtProvider.getEmailFromJwtToken(jwt);
		User user = userRepo.findByEmail(email);
		return user;
	}

}
