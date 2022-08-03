package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public int login(String username, String password) {
		return userRepository.findUser(username, password);
	}

	@Override
	public boolean existByUsername(String username) {
		return userRepository.existsById(username);
	}

	@Override
	public void signup(User user) {
		userRepository.save(user);
	}

}
