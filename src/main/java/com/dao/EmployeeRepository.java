package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByEmailAndPassword(String email, String password);
	Employee findByEmployeeId(int employeeId);

}
