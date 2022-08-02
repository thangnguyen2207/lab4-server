package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentForm {
	private int projectId;
	private int employeeId;
	private double hoursWorked;
	private String isChecked;
	
}
