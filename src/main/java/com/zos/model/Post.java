package com.zos.model;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String image;
	
	@ManyToOne
	private User user;
	
	@OneToMany
	private List<Comments> comments=new ArrayList<Comments>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<User> likedByUsers= new HashSet<>(); 
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(Integer id, String title, String image, User user, List<Comments> comments, Set<User> likedByUsers) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.user = user;
		this.comments = comments;
		this.likedByUsers = likedByUsers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public Set<User> getLikedByUsers() {
		return likedByUsers;
	}

	public void setLikedByUsers(Set<User> likedByUsers) {
		this.likedByUsers = likedByUsers;
	}

	

	

	
	
	
}
