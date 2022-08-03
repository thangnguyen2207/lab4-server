package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.User;
import com.example.service.UserService;

@SpringBootApplication
public class Lab4NguyenChonThangApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Lab4NguyenChonThangApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.signup(new User("admin", "1"));		
	}

}
