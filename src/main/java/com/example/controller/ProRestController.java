package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Project;
import com.example.service.ProjectService;
import com.example.utils.Response;

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
	
	@CrossOrigin
	@PostMapping("/add")
	public Response addProject(@RequestBody Project project) {
		projectService.addProject(project);
		return new Response(0, "");
	}
}
