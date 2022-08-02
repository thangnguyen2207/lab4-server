package com.example.service;

public interface UserService {

	public int login(String username, String password);
	
	public boolean existByUsername(String username);
}
