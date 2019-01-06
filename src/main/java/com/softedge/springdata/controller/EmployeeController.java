package com.softedge.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softedge.springdata.exception.EmployeeNotFoundException;
import com.softedge.springdata.model.Employee;
import com.softedge.springdata.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable int employeeId) {
		Employee employee = null;
		ResponseEntity<Employee> response = null;

		try {
			employee = employeeService.findById(employeeId);
			response = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			response = new ResponseEntity<Employee>(employee, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> findAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
	}

	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
	}

	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int employeeId) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employeeService.deleteEmployee(employee);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	
	@GetMapping("/employees/{employeeName}")
	public ResponseEntity<List<Employee>> findEmployeeByEmployeeName(@PathVariable("employeeName") String employeeName) {
		return new ResponseEntity<List<Employee>>(employeeService.findEmployeeByEmployeeName(employeeName), HttpStatus.OK);
	}

	@GetMapping("/allEmployees/{employeeDepartment}/{employeeSalary}")
	public List<Employee> findEmployees(@PathVariable String employeeDepartment, @PathVariable double employeeSalary) {
		return employeeService.findEmployees(employeeDepartment, employeeSalary);
	}

	
}
