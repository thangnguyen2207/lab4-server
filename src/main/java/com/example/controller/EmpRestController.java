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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.EmployeeSearch;
import com.example.model.ResponseBody;
import com.example.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmpRestController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public ResponseEntity<?> getEmployees() {
		List<Employee> employees = employeeService.getEmployees();
		return new ResponseEntity<>(new ResponseBody<>(0, employees), HttpStatus.OK);
	}
	
	@GetMapping("/list/search/{proId}")
	public ResponseEntity<?> getEmployeeSearchs(@PathVariable int proId) {
		List<EmployeeSearch> employeeSearchs = employeeService.getAssignedEmployeesByProId(proId);
		return new ResponseEntity<>(new ResponseBody<>(0, employeeSearchs), HttpStatus.OK);
	}
	
	@GetMapping("/{proId}/assign")
	public ResponseEntity<?> getAssignedEmployees(@PathVariable int proId) {
		List<EmployeeSearch> assignedEmployee = employeeService.getAssignedEmployeesByProId(proId);
		return new ResponseEntity<>(new ResponseBody<>(0, assignedEmployee), HttpStatus.OK);
	}
	
	@GetMapping("/{proId}/notAssign")
	public ResponseEntity<?> getNotAssignEmployees(@PathVariable int proId) {
		List<EmployeeSearch> notAssignEmployees = employeeService.getNotAssignedEmployeesByProId(proId);
		return new ResponseEntity<>(new ResponseBody<>(0, notAssignEmployees), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return new ResponseEntity<>(new ResponseBody<>(0, "OK"), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return new ResponseEntity<>(new ResponseBody<>(0, "OK"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteEmployee(@RequestParam int empId) {
		employeeService.deleteEmployeesById(empId);
		return new ResponseEntity<>(new ResponseBody<>(0, "OK"), HttpStatus.OK);
	}
}
