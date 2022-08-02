package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Project;
import com.example.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(int id) {
		return projectRepository.findById(id).orElse(null);
	}

	@Override
	public void addProject(Project project) {
		projectRepository.save(project);
	}

	@Override
	public void deleteProject(int id) {
		projectRepository.deleteById(id);
	}	
	
}
