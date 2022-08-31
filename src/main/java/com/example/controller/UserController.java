package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.JwtTokenProvider;
import com.example.model.ResponseBody;
import com.example.model.User;

@CrossOrigin(exposedHeaders = "token")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider tokenProvider;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
//		int count = userService.login(user.getUsername(), user.getPassword());
//		log.info(token);
//		
//		if (count > 0) {
//			HttpHeaders headers = new HttpHeaders();
//			headers.set("token", "This is jwt token");
//			return new ResponseEntity<>(new 
//					ResponseBody<String>(0, "OK"), headers, HttpStatus.OK);
//		}
//		
//		return new ResponseEntity<>(new 
//				ResponseBody<String>(1, "Sai tên tài khoản hoặc mật khẩu"), HttpStatus.OK);
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken(user);
		
		return new ResponseEntity<>(new ResponseBody<>(0, jwt), HttpStatus.OK);
	}
	
}
