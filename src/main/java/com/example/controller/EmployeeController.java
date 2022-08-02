package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Employee;
import com.example.model.EmployeeSearch;
import com.example.model.Project;
import com.example.service.EmployeeService;
import com.example.service.ProjectService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/list")
	public String getEmployeeList(Model model) {
		List<Employee> employeeList = employeeService.getEmployees();
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}
	
	@GetMapping("/add")
	public String getAddEmployee(@ModelAttribute Employee employee, Model model) {
		return "employee/add";
	}
	
	@PostMapping("/add")
	public String addEmployee(@ModelAttribute Employee employee, Model model) {
		employeeService.saveEmployee(employee);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/list/search")
	public String getEmployeeSearch(@ModelAttribute Project project, Model model) {
		List<Project> projectList = projectService.getProjects();
		List<EmployeeSearch> employeeSearchList = employeeService.getAssignedEmployeesByProId(projectList.get(0).getProjectId());
		model.addAttribute("employeeSearchList", employeeSearchList);
		model.addAttribute("projectList", projectList);
		return "employee/list_search";
	}
	
	@PostMapping("/list/search")
	public String postEmployeeSearch(@ModelAttribute Project project, Model model) {
		List<Project> projectList = projectService.getProjects();
		List<EmployeeSearch> employeeSearchList = employeeService.getAssignedEmployeesByProId(project.getProjectId());
		model.addAttribute("employeeSearchList", employeeSearchList);
		model.addAttribute("projectList", projectList);
		return "employee/list_search";
	}
	
	
	
}
