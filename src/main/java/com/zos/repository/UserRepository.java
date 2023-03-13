package com.zos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zos.exception.UserException;
import com.zos.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> findByEmail(String email);
	
	public Optional<User> findByUsername(String username);
}
