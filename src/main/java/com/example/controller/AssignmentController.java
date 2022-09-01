package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Assignment;
import com.example.model.EmployeeSearch;
import com.example.model.ResponseBody;
import com.example.service.AssignmentService;

@CrossOrigin
@RestController
@RequestMapping("/api/assign")
public class AssignmentController {
	@Autowired
	private AssignmentService assignmentService;
	
	@PostMapping("/{proId}")
	public ResponseEntity<?> assignEmployee(@PathVariable int proId, @RequestBody List<EmployeeSearch> empSearchs) {
		List<Assignment> assignments = new ArrayList<>();
		empSearchs.forEach((emp) -> {
			assignments.add(new Assignment(proId, emp.getEmployeeId(), emp.getHoursWorked()));
		});
		assignmentService.saveAllAssignments(assignments);
		return new ResponseEntity<>(new ResponseBody<>(0, "OK"), HttpStatus.OK);
	}
	

}