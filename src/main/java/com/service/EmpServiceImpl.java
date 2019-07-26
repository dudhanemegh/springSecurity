package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.EmployeeRepository;
import com.model.Employee;

public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Employee saveEmployee(final Employee employee) {

		return this.empRepository.save(employee);
	}

	@Override
	public Employee getEmployee(final Employee employee) {

		return this.empRepository.findByEmailAndPassword(employee.getEmail(), employee.getPassword());
	}

	@Override
	public List<Employee> getAllEmployees() {

		return this.empRepository.findAll();
	}

	@Override
	public Employee editEmployee(final int employeeId, final Employee employee) {
		final Employee e= this.empRepository.findByEmployeeId(employeeId);
		return this.empRepository.save(e);
	}

	@Override
	public void deleteEmployee(final int employeeId) {
		this.empRepository.deleteById(employeeId);

	}

}
