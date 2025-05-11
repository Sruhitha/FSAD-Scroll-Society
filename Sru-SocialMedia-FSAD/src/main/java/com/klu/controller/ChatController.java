package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.klu.Model.Chat;
import com.klu.Model.User;
import com.klu.request.ChatRequest;
import com.klu.service.ChatService;
import com.klu.service.UserService;

@RestController
public class ChatController {

	@Autowired
	private ChatService chatService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/chats")
	public Chat createChat(@RequestHeader ("Authorization")String jwt,@RequestBody ChatRequest req) throws Exception {
		User reqUser = userService.findUserByJWT(jwt);
		User user2 = userService.findUserById(req.getUserId());
		Chat chat = chatService.createChat(reqUser, user2);
		return chat;
		
	}
	
	@GetMapping("/api/chats")
	public List<Chat> findUsersChat(@RequestHeader ("Authorization")String jwt) {
		User user = userService.findUserByJWT(jwt);
		List<Chat> chats = chatService.findUsersChat(user.getId());
		return chats;
		
	}
}
