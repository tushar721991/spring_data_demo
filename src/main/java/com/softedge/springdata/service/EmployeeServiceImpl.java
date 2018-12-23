package com.softedge.springdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softedge.springdata.exception.EmployeeNotFoundException;
import com.softedge.springdata.model.Employee;
import com.softedge.springdata.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findById(int employeeId) throws EmployeeNotFoundException {
		Optional<Employee> data = employeeRepository.findById(employeeId);
		if (data.isPresent()) {
			return data.get();
		}
		throw new EmployeeNotFoundException("Employee Record Doesn't exist");
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
