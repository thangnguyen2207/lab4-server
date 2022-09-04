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
	private String name;
	private double hoursWorked;
	private boolean isDeleted;
	private boolean isChanged;
}
