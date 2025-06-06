package com.klu.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Chat {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		private String chat_name;
		private String chat_image;
		
		
		private Boolean is_group;
		
		@ManyToOne
		private User created_by;
		
		@ManyToMany
		private List<User> users = new ArrayList<>();
	 
		private LocalDateTime timestamp;
		//@JsonIgnore
		@OneToMany( mappedBy = "chat")
		private List<Message> messages = new ArrayList<>();

		public Chat() {
			
		}

		public Chat(Integer id, String chat_name, String chat_image, Boolean is_group, User created_by,
				List<User> users, LocalDateTime timestamp,List<Message> messages) {
			super();
			this.id = id;
			this.chat_name = chat_name;
			this.chat_image = chat_image;
			this.is_group = is_group;
			this.created_by = created_by;
			this.users = users;
			this.timestamp = timestamp;
			this.messages = messages;
		}



		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getChat_name() {
			return chat_name;
		}

		public void setChat_name(String chat_name) {
			this.chat_name = chat_name;
		}

		public String getChat_image() {
			return chat_image;
		}

		public void setChat_image(String chat_image) {
			this.chat_image = chat_image;
		}

		public Boolean getIs_group() {
			return is_group;
		}

		public void setIs_group(Boolean is_group) {
			this.is_group = is_group;
		}

		public User getCreated_by() {
			return created_by;
		}

		public void setCreated_by(User created_by) {
			this.created_by = created_by;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

		public List<Message> getMessages() {
			return messages;
		}

		public void setMessages(List<Message> messages) {
			this.messages = messages;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
		
		
		
	}

