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
	
	private boolean isDeleted;
	
	private boolean isChanged;

	public EmployeeSearch(int employeeId, String firstName, String lastName, String phone, String email, double hoursWorked) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.hoursWorked = hoursWorked;
		this.isDeleted = false;
		this.isChanged = false;
	}
	
	public EmployeeSearch(int employeeId, String firstName, String lastName, String phone, String email) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.hoursWorked = 0.0;
		this.isDeleted = false;
		this.isChanged = false;
	}
	
	
}
