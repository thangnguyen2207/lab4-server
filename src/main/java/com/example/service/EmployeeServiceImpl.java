package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.model.EmployeeSearch;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeesById(int id) {
		employeeRepository.deleteById(id);;
	}

	@Override
	public List<Employee> getEmployeesById(List<Integer> ids) {
		Iterable<Integer> idsIterable = ids;
		return employeeRepository.findAllById(idsIterable);
	}

	@Override
	public List<EmployeeSearch> getAssignedEmployeesByProId(int proId) {
		return employeeRepository.findAllAssignedByProId(proId);
	}

	@Override
	public List<EmployeeSearch> getNotAssignedEmployeesByProId(int proId) {
		return employeeRepository.findAllNotAssignedByProId(proId);
	}

}
