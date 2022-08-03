package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.EmployeeSearch;
import com.example.service.EmployeeService;
import com.example.utils.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/employee")
public class EmpRestController {
	@Autowired
	private EmployeeService employeeService;

	@CrossOrigin
	@GetMapping("/list")
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeService.getEmployees();
		return employees;
	}
	
	@CrossOrigin
	@GetMapping("/list/search/{proId}")
	public List<EmployeeSearch> getEmployeeSearchs(@PathVariable int proId) {
		log.info(proId + "");
		List<EmployeeSearch> employeeSearchs = employeeService.getAssignedEmployeesByProId(proId);
		return employeeSearchs;
	}
	
	@CrossOrigin
	@GetMapping("/{proId}/assign")
	public List<EmployeeSearch> getAssignedEmployees(@PathVariable int proId) {
		List<EmployeeSearch> assignedEmployee = employeeService.getAssignedEmployeesByProId(proId);
		return assignedEmployee;
	}
	
	@CrossOrigin
	@GetMapping("/{proId}/notAssign")
	public List<EmployeeSearch> getNotAssignEmployees(@PathVariable int proId) {
		List<EmployeeSearch> notAssignEmployees = employeeService.getNotAssignedEmployeesByProId(proId);
		return notAssignEmployees;
	}

	@CrossOrigin
	@PostMapping("/add")
	public Response addEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return new Response(0, "");
	}
}
