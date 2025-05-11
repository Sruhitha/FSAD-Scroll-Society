package com.klu.service;

import java.util.List;

import com.klu.Model.Chat;
import com.klu.Model.Message;
import com.klu.Model.User;

public interface MessageService {

	public Message createMessage(User user, Integer chatId,Message req) throws Exception;
	public List<Message> findChatsMessages(Integer chatId) throws Exception;
}
