package com.example.service;

import com.example.model.User;

public interface UserService {
	public void signup(User user);

	public int login(String username, String password);
	
	public boolean existByUsername(String username);
	
	public User findUserById(Integer id);
	
	public User findUserByUsername(String username);
}
