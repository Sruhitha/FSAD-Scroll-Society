package com.klu.service;

import java.util.List;

import com.klu.Model.User;
import com.klu.exceptions.UserException;

public interface UserService {
	public User registerUser(User user);
	public User findUserById (Integer userId) throws UserException;
	public User findUserByEmail(String email);
	public User followUser(Integer userId1,Integer userId2) throws UserException;
	public List<User> searchUser(String query);
	User updateUser(User user, Integer userId) throws UserException;
	public User findUserByJWT(String jwt);

}
