package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Project;
import com.example.model.ResponseBody;
import com.example.service.ProjectService;

@CrossOrigin
@RestController
@RequestMapping("/api/project")
public class ProRestController {
	@Autowired
	private ProjectService projectService;

	@GetMapping("/list")
	public ResponseEntity<?> getProjects() {
		List<Project> projects = projectService.getProjects();
		return new ResponseEntity<>(new ResponseBody<>(0, projects), HttpStatus.OK);
	}
	
	@GetMapping("/{proId}")
	public ResponseEntity<?> getProject(@PathVariable int proId) {
		Project project = projectService.getProjectById(proId);
		return new ResponseEntity<>(new ResponseBody<>(0, project), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addProject(@RequestBody Project project) {
		projectService.addProject(project);
		return new ResponseEntity<>(new ResponseBody<>(0, "OK"), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateProject(@RequestBody Project project) {
		projectService.updateProject(project);
		return new ResponseEntity<>(new ResponseBody<>(0, "OK"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{proId}")
	public ResponseEntity<?> deleteProject(@PathVariable int proId) {
		projectService.deleteProject(proId);
		return new ResponseEntity<>(new ResponseBody<>(0, "OK"), HttpStatus.OK);
	}
}
