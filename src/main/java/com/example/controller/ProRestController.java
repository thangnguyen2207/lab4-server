package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Project;
import com.example.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProRestController {
	@Autowired
	private ProjectService projectService;

	@CrossOrigin
	@GetMapping("/list")
	public List<Project> getProjects() {
		List<Project> projects = projectService.getProjects();
		return projects;
	}
}
