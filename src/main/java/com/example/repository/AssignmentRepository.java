package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
	
	@Modifying
	@Transactional
	@Query("delete from Assignment a where a.project.projectId = :projectId and a.employee.employeeId in :employeeIds")
	public void deleteById(@Param("projectId") int projectId, @Param("employeeIds") List<Integer> employeeIds);
}
