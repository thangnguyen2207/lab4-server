package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByUsername(username);
		
		if (user == null ) {
			throw new UsernameNotFoundException(username);
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), new ArrayList<>());
	}
	
	public UserDetails loadUserByUserId(Integer userId) {
		User user = userService.findUserById(userId);
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), new ArrayList<>());
	}

}
