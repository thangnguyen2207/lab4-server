package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT COUNT(u) from User u WHERE u.username = ?1 AND u.password = ?2")
	public int findUser(String username, String password);
	
	public User findByUsername(String username);
}
