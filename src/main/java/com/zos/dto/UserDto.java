package com.zos.dto;

import java.util.Objects;

public class UserDto {
	
	private String username;
	private String email;
	private Integer id;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public UserDto(String username, String email, Integer id) {
		super();
		this.username = username;
		this.email = email;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		UserDto other = (UserDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(username, other.username);
	}



	@Override
	public String toString() {
		return "UserDto [username=" + username + ", email=" + email + ", id=" + id + "]";
	}
	
	
	
	

}
