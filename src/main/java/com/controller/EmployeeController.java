package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.service.EmpService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmpService empService;
	//To get one user
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public ResponseEntity<Employee> loginEmployee(@RequestBody final Employee employee) {

		return new ResponseEntity<>(this.empService.getEmployee(employee),HttpStatus.FOUND);
	}

	//To save specific faculty or admin
	@RequestMapping(value ="/employee/{employeeId}",method = RequestMethod.POST)
	public ResponseEntity<Employee> saveEmployee(@PathVariable final int employeeId, @RequestBody final Employee employee) {

		return new ResponseEntity<>(this.empService.saveEmployee(employee),HttpStatus.CREATED);
	}

	//To get all users(faculty,admin)
	@RequestMapping(value ="/employee",method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployee() {

		return new ResponseEntity<>(this.empService.getAllEmployees(),HttpStatus.FOUND);
	}

	//To edit specific faculty or admin
	@RequestMapping(value ="/employee/{employeeId}",method = RequestMethod.PUT)
	public ResponseEntity<Employee> editEmployee(@PathVariable final int employeeId, @RequestBody final Employee employee) {

		return new ResponseEntity<>(this.empService.editEmployee(employeeId,employee),HttpStatus.OK);
	}

	//To delete specific faculty or admin
	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> editEmployee(@PathVariable final int employeeId)
	{
		this.empService.deleteEmployee(employeeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
