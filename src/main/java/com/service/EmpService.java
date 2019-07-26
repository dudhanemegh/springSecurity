package com.service;

import java.util.List;

import com.model.Employee;

public interface EmpService {

	Employee saveEmployee(Employee employee);
	Employee getEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee editEmployee(int employeeId, Employee employee);
	void deleteEmployee(int employeeId);

}
