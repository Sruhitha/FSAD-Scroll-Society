package com.klu.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.Model.Message;

public interface MessageRepo extends JpaRepository<Message,Integer>{

	public List<Message> findByChatId(Integer chatId);
}
