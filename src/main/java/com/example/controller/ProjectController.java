package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Assignment;
import com.example.model.AssignmentForm;
import com.example.model.AssignmentFormList;
import com.example.model.EmployeeSearch;
import com.example.model.Project;
import com.example.service.AssignmentService;
import com.example.service.EmployeeService;
import com.example.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AssignmentService assignmentService;
	
	@GetMapping("/list")
	public String getProject(Model model) {
		List<Project> projectList = projectService.getProjects();
		model.addAttribute("projectList", projectList);
		return "project/list";
	}
	
	@GetMapping("/add")
	public String getAddProject(@ModelAttribute Project project, Model model) {
		return "/project/add";
	}
	
	@PostMapping("/add")
	public String addProject(@ModelAttribute Project project, Model model) {
		projectService.addProject(project);
		return "redirect:/project/add";
	}
	
	@PostMapping(value = "/detail", params = "update")
	public String updateProject(@ModelAttribute Project project,
			RedirectAttributes redirectAttributes, Model model) {
		redirectAttributes.addFlashAttribute("showToast", "1");
		projectService.addProject(project);
		return "redirect:/project/detail/" + project.getProjectId();
	}
	
	@PostMapping(value = "/detail", params = "delete")
	public String deleteProject(@ModelAttribute Project project, Model model) {
		projectService.deleteProject(project.getProjectId());
		return "redirect:/project/list";
	}
	
	@GetMapping("detail/{projectId}")
	public String getProjectAssign(@PathVariable("projectId") int projectId, 
			@ModelAttribute AssignmentFormList assignmentFormList, Model model) {
		Project project = projectService.getProjectById(projectId);
		List<EmployeeSearch> assignedEmployee = employeeService.getAssignedEmployeesByProId(projectId);
		List<EmployeeSearch> notAssignedEmployee = employeeService.getNotAssignedEmployeesByProId(projectId);
		model.addAttribute("assignedEmployee", assignedEmployee);
		model.addAttribute("notAssignedEmployee", notAssignedEmployee);
		model.addAttribute("project", project);
		return "project/detail";
	}
	
	@PostMapping("/detail/{projectId}/delete")
	public String deleteAssignedEmployee(@RequestParam(value = "deleteIds", required = false) Integer[] deleteIds,
			@PathVariable("projectId") int projectId) {
		if (deleteIds != null) {
			List<Integer> deleteIdList = Arrays.asList(deleteIds);
			assignmentService.deleteAssignments(projectId, deleteIdList);
		}
		return "redirect:/project/detail/" + projectId;
	}
	
	@PostMapping("/detail/{projectId}/add")
	public String addAssignEmployee(@ModelAttribute AssignmentFormList assignmentFormList, 
			@PathVariable("projectId") int projectId, Model model) {
		List<Assignment> assignments = new ArrayList<>();
		if (assignmentFormList.getAssignments() != null) {
			List<AssignmentForm> aForms = assignmentFormList.getAssignments();
			
			for (int i = 0; i < aForms.size(); i++) {
				if (aForms.get(i).getIsChecked() != null) {
					assignments.add(new Assignment(
							projectId, 
							aForms.get(i).getEmployeeId(), 
							aForms.get(i).getHoursWorked()));
				}
			}
			
			assignmentService.saveAllAssignments(assignments);
		}
		return "redirect:/project/detail/" + projectId;
	}
	
}
