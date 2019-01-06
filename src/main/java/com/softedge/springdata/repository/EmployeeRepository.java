package com.softedge.springdata.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.softedge.springdata.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


	public List<Employee> findEmployeeByEmployeeName(String employeeName);

	@Query("FROM Employee where employeeDepartment = ?1 AND employeeSalary >= ?2")
	public List<Employee> findEmployees(String employeeDepartment, double employeeSalary);
	
}
