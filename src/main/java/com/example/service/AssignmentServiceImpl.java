package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Assignment;
import com.example.repository.AssignmentRepository;

@Service
public class AssignmentServiceImpl implements AssignmentService {
	@Autowired
	private AssignmentRepository assignmentRepository;

	@Override
	public void deleteAssignments(int projectId, List<Integer> employeeIds) {
		assignmentRepository.deleteById(projectId, employeeIds);
	}

	@Override
	public void saveAllAssignments(List<Assignment> assignments) {
		assignmentRepository.saveAll(assignments);
	}

}
