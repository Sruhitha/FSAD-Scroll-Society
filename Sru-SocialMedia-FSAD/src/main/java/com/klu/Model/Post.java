package com.klu.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String caption;
	private String image;
	private String video;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	@OneToMany
	private List<User> liked = new ArrayList<>();
	private LocalDateTime createdAt;
	@OneToMany
	private List<Comment> comments = new ArrayList<>();
	public Post() {
		
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public List<User> getLiked() {
		return liked;
	}
	public void setLiked(List<User> liked) {
		this.liked = liked;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Post(Integer id, String caption, String image, String video, User user, List<User> liked,
			LocalDateTime createdAt, List<Comment> comments) {
		super();
		Id = id;
		this.caption = caption;
		this.image = image;
		this.video = video;
		this.user = user;
		this.liked = liked;
		this.createdAt = createdAt;
		this.comments = comments;
	}
	
	
	

}
