package com.example.service;

import java.util.List;

import com.example.model.Assignment;

public interface AssignmentService {
	
	public void deleteAssignments(int projectId, List<Integer> employeeIds);
	
	public void saveAllAssignments(List<Assignment> assignments);
}
