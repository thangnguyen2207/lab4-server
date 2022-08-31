package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column
	private String password;

	public User(String username, String password) {
		this.id = 0;
		this.username = username;
		this.password = password;
	}
	
	
}
