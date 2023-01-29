package com.zos.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@NotNull
	private User user;
	
	@NotNull
	private String content;
	
	@OneToMany
	private Set<User> likedByUsers= new HashSet<>();
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Comments(Integer id, @NotNull User user, @NotNull String content, Set<User> likedByUsers) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.likedByUsers = likedByUsers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<User> getLikedByUsers() {
		return likedByUsers;
	}

	public void setLikedByUsers(Set<User> likedByUsers) {
		this.likedByUsers = likedByUsers;
	}

	
	
	

}
