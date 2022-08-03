package com.example.service;

import com.example.model.User;

public interface UserService {
	public void signup(User user);

	public int login(String username, String password);
	
	public boolean existByUsername(String username);
}
