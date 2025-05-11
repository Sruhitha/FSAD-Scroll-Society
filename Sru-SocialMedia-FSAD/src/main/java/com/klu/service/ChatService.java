package com.klu.service;

import java.util.List;

import com.klu.Model.Chat;
import com.klu.Model.User;

public interface ChatService {
	public Chat createChat(User reqUser, User user);
	public Chat findChatById(Integer chatId) throws Exception;
	public List<Chat> findUsersChat(Integer userId);

}
