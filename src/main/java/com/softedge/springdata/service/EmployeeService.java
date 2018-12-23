package com.softedge.springdata.service;

import java.util.List;

import com.softedge.springdata.exception.EmployeeNotFoundException;
import com.softedge.springdata.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Employee findById(int employeeId) throws EmployeeNotFoundException;
	public List<Employee> findAll();
}
