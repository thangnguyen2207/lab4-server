package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSearch {
	private int employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private String email;
	
	private double hoursWorked;

	public EmployeeSearch(int employeeId, String firstName, String lastName, String phone, String email) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}
	
	
}
