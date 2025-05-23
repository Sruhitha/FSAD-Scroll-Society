package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.klu.Model.Message;
import com.klu.Model.User;
import com.klu.service.MessageService;
import com.klu.service.UserService;

@RestController
public class CreateMessage {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/messages/chat/{chatId}")
	public Message createMessage(@RequestBody Message req,@RequestHeader("Authorization")String jwt,@PathVariable Integer chatId) throws Exception {
		User user = userService.findUserByJWT(jwt);
		Message message = messageService.createMessage(user, chatId, req);
		return message;
	}
	
	@GetMapping("/api/messages/chat/{chatId}")
	public List<Message> findChatsMessage(@RequestHeader("Authorization")String jwt,@PathVariable Integer chatId) throws Exception {
		User user = userService.findUserByJWT(jwt);
		List<Message> messages = messageService.findChatsMessages(chatId);
		return messages;
		
	}
}
