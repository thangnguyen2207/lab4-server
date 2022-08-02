package com.example.service;

import java.util.List;

import com.example.model.Employee;
import com.example.model.EmployeeSearch;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public List<Employee> getEmployeesById(List<Integer> id);
	
	public List<EmployeeSearch> getAssignedEmployeesByProId(int proId);
	
	public List<EmployeeSearch> getNotAssignedEmployeesByProId(int proId);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployeesById(int id);
	
}
