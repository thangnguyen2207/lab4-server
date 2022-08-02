package com.example.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "assignment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {
	@EmbeddedId
	private AssignmentKey assignmentKey;
	
	@ManyToOne
	@MapsId("projectId")
	@JoinColumn(name = "projectId")
	private Project project;
	
	@ManyToOne
	@MapsId("employeeId")
	@JoinColumn(name = "employeeId")
	private Employee employee;
	
	@Column(precision = 8, scale = 2)
	private double hoursWorked;

	public Assignment(int projectId, int employeeId, double hoursWorked) {
		this.assignmentKey = new AssignmentKey(projectId, employeeId);
		this.project = new Project(projectId);
		this.employee = new Employee(employeeId);
		this.hoursWorked = hoursWorked;
	}	
	
}
