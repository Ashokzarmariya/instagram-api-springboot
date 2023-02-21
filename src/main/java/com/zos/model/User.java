package com.zos.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.zos.dto.UserDto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String username;
	private String email;
	private String password;
	
	@ElementCollection
	@Embedded
	private Set<UserDto> follower = new HashSet<UserDto>();
	
	@ElementCollection
	@Embedded
	private Set<UserDto> following = new HashSet<UserDto>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(Integer id, String username, String email, String password, Set<UserDto> follower,
			Set<UserDto> following) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.follower = follower;
		this.following = following;
	}







	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public Set<UserDto> getFollower() {
		return follower;
	}



	public void setFollower(Set<UserDto> follower) {
		this.follower = follower;
	}



	public Set<UserDto> getFollowing() {
		return following;
	}



	public void setFollowing(Set<UserDto> following) {
		this.following = following;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	



	



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", follower=" + follower + ", following=" + following + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(username, other.username);
	}
	
	
	
}
