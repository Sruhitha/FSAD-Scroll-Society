package com.klu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.Model.Chat;
import com.klu.Model.Message;
import com.klu.Model.User;
import com.klu.Repository.ChatRepo;
import com.klu.Repository.MessageRepo;

@Service
public class MessageServiceImplementation implements MessageService{

	@Autowired
	private MessageRepo messageRepo;
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ChatRepo chatRepo;

	@Override
	public List<Message> findChatsMessages(Integer chatId) throws Exception {
		Chat chat = chatService.findChatById(chatId);
		return messageRepo.findByChatId(chatId);
	}



	@Override
	public Message createMessage(User user, Integer chatId, Message req) throws Exception {
		
		Message message = new Message();
		Chat chat = chatService.findChatById(chatId);
		message.setChat(chat);
		message.setContent(req.getContent());
		message.setImage(req.getImage());
		message.setUser(user);
		message.setTimestamp(LocalDateTime.now());
		Message savedMessage = messageRepo.save(message);
		chat.getMessages().add(savedMessage);
		chatRepo.save(chat);
		return savedMessage;
	}

}
