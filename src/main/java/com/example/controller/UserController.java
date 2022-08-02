package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;
import com.example.utils.Response;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@CrossOrigin
	@PostMapping("/login")
	public Response login(@RequestBody User user) {
		int count = userService.login(user.getUsername(), user.getPassword());
		Response res = new Response();
		if (count == 0) {
			res.setCode(1);
			res.setMessage("Sai tài khoản hoặc mật khẩu");
		} else {
			res.setCode(0);
			res.setMessage("");
		}
		
		return res;
	}
	
	@CrossOrigin
	@PostMapping("/user/{username}")
	public Response findUsername(@PathVariable String username) {
		Response res = new Response();
		if (!userService.existByUsername(username)) {
			res.setCode(1);
			res.setMessage("Không tìm thấy tài khoản");
		} else {
			res.setCode(0);
			res.setMessage("");
		}
		
		return res;
	}
	
}
