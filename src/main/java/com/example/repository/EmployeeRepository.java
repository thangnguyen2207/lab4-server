package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Employee;
import com.example.model.EmployeeSearch;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select new com.example.model.EmployeeSearch(e.employeeId, e.firstName, e.lastName, e.phone, e.email, a.hoursWorked) "
			+ "from Employee e "
			+ "join e.assignments a join a.project p "
			+ "where p.projectId = :projectId")
	public List<EmployeeSearch> findAllAssignedByProId(@Param("projectId") int proId);
	
	@Query("select distinct new com.example.model.EmployeeSearch(e.employeeId, e.firstName, e.lastName, e.phone, e.email) "
			+ "from Employee e where e.employeeId not in ("
			+ "select e.employeeId from Employee e, Assignment a, Project p "
			+ "where e.employeeId = a.assignmentKey.employeeId and a.assignmentKey.projectId = p.projectId and p.projectId = :projectId)")
	public List<EmployeeSearch> findAllNotAssignedByProId(@Param("projectId") int proId);

}
