package com.example.service;

import java.util.List;

import com.example.model.Project;

public interface ProjectService {
	public List<Project> getProjects();
	
	public Project getProjectById(int id);
	
	public void addProject(Project project);
	
	public void updateProject(Project project);
	
	public void deleteProject(int id);
	
}
