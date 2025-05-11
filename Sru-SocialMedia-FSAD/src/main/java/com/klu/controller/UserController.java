package com.klu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.Model.User;
import com.klu.Repository.UserRepo;
import com.klu.exceptions.UserException;
import com.klu.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		//User newUser = new User();
		//newUser.setEmail(user.getEmail());
		//newUser.setFirstName(user.getFirstName());
		//newUser.setLastName(user.getLastName());
		//newUser.setPassword(user.getPassword());
		//newUser.setId(user.getId());
		
		//User savedUser = userRepo.save(newUser);
		User savedUser = userService.registerUser(user);
		return savedUser;
	}
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}
	
	@GetMapping("/api/users/{userId}")
	public User getUserById(@PathVariable("userId") Integer Id) throws UserException {
		User user = userService.findUserById(Id);
		return user;
	}
	
	@PutMapping("/api/users")
	public User updateUser(@RequestHeader("Authorization")String jwt, @RequestBody User user) throws UserException{
		User reqUser = userService.findUserByJWT(jwt);
		User updatedUser = userService.updateUser(user, reqUser.getId());
		return updatedUser;
	}
	
	@PutMapping("/api/users/follow/{userId2}")
	public User followUserhandler(@RequestHeader("Authorization")String jwt, @PathVariable Integer userId2) throws UserException {
		User reqUser = userService.findUserByJWT(jwt);
		User user = userService.followUser(reqUser.getId(), userId2);
		return user;
	}
	
	@GetMapping("/api/users/search")
	public List<User> searchUser(@RequestParam("query") String query){
		List<User> users = userService.searchUser(query);
		return users;
	}
	
	
	@GetMapping("/api/users/profile")
	public User getUserFromToken(@RequestHeader("Authorization")String jwt) {
		User user = userService.findUserByJWT(jwt);
		user.setPassword(null);
		return user;
	}
	
	@DeleteMapping("users/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) throws UserException {
		Optional<User> user = userRepo.findById(userId);
		if(user.isEmpty()) {
			throw new UserException("User Not Exist with userId"+userId);
		}
		userRepo.delete(user.get());
		return "user deleted succesfully with id "+userId;
	}
}
