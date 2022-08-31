package com.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Assignment;
import com.example.model.Employee;
import com.example.model.Project;
import com.example.model.User;
import com.example.service.AssignmentService;
import com.example.service.EmployeeService;
import com.example.service.ProjectService;
import com.example.service.UserService;

@SpringBootApplication
public class Lab4NguyenChonThangApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AssignmentService assignmentService;
	
	@Autowired
	private ProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(Lab4NguyenChonThangApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.signup(new User("admin", "$2a$12$m/VSds.jcHOZ7cnRLaE/1ezWdqxCljLUSYG0vhUrJ7HjWlWL3Kv8m"));
		
		employeeService.saveEmployee(new Employee(0, null, "Mary", "Jacobs", "360-285-8110", "Mary.Jacobs@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "Rosalie", "Jackson", "360-285-8120", "Rosalie.Jackson@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "Richard", "Bandalone",  "360-285-8210", "Richard.Bandalone@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "Tom", "Caruthers",  "360-285-8310", "Tom.Caruthers@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "Heather", "Jones",  "360-285-8320", "Heather.Jones@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "Mary", "Abernathy", "360-285-8410", "Mary.Abernathy@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "George", "Smith",  "360-285-8510", "George.Smith@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "Tom", "Jackson",  "360-287-8610", "Tom.Jackson@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "George", "Jones", "360-287-8620", "George.Jones@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "Ken", "Numoto", "360-287-8710", "Ken.Mumoto@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "James", "Nestor", null, "James.Nestor@WPC.com"));
		employeeService.saveEmployee(new Employee(0, null, "Rick", "Brown","360-287-8820", "Rick.Brown@WPC.com"));
		
		DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		projectService.addProject(new Project(0, null, "2013 Q3 Product Plan",  135.00, 
				dateFormat.parse("2022-05-10"), dateFormat.parse("2022-06-15")));
		projectService.addProject(new Project(0, null, "2013 Q3 Portfolio Analysis",  120.00, 
				dateFormat.parse("2022-07-05"), dateFormat.parse("2022-07-25")));
		projectService.addProject(new Project(0, null, "2013 Q3 Tax Preparation", 145.00, 
				dateFormat.parse("2022-08-10"), dateFormat.parse("2022-10-15")));
		projectService.addProject(new Project(0, null, "2013 Q4 Product Plan",  150.00, 
				dateFormat.parse("2022-08-10"), dateFormat.parse("2022-09-15")));
		projectService.addProject(new Project(0, null, "2013 Q4 Portfolio Analysis", 140.00, 
				dateFormat.parse("2022-10-05"), null));
		
		List<Assignment> assignments = new ArrayList<>();
		assignments.add(new Assignment(1, 1, 30.0));
		assignments.add(new Assignment(1, 8, 75.0));
		assignments.add(new Assignment(1, 10, 55.0));
		assignments.add(new Assignment(2, 4, 40.0));
		assignments.add(new Assignment(2, 6, 45.0));
		assignments.add(new Assignment(3, 1, 25.0));
		assignments.add(new Assignment(3, 2, 20.0));
		assignments.add(new Assignment(3, 4, 45.0));
		assignments.add(new Assignment(3, 5, 40.0));
		assignments.add(new Assignment(4, 1, 35.0));
		assignments.add(new Assignment(4, 8, 80.0));
		assignments.add(new Assignment(4, 10, 50.0));
		assignments.add(new Assignment(5, 4, 15.0));
		assignments.add(new Assignment(5, 5, 10.0));
		assignments.add(new Assignment(5, 6, 27.5));
		
		assignmentService.saveAllAssignments(assignments);
	}

}
