package com.klu.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.Model.Chat;
import com.klu.Model.User;
import com.klu.Repository.ChatRepo;
import com.klu.Repository.UserRepo;

@Service
public class ChatServiceImplementation implements ChatService{

	@Autowired
	private ChatRepo chatRepo;
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public Chat createChat(User reqUser, User user2) {
		Chat isExist = chatRepo.findChatByUserId(user2, reqUser);
		if(isExist!=null) {
			return isExist;
		}
		Chat chat = new Chat();
		chat.getUsers().add(user2);
		chat.getUsers().add(reqUser);
		chat.setTimestamp(LocalDateTime.now());
		return chatRepo.save(chat);
	}

	@Override
	public Chat findChatById(Integer chatId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Chat> opt = chatRepo.findById(chatId);
		
	if(opt.isEmpty()) {
		throw new Exception("chat not found with id - "+chatId);
	}
	return opt.get();
	}

	@Override
	public List<Chat> findUsersChat(Integer userId) {
		// TODO Auto-generated method stub
		return chatRepo.findByUsersId(userId);
	}

}
