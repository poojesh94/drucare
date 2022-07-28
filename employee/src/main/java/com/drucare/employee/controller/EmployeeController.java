package com.drucare.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.drucare.employee.demo.InsertOrUpdate;
import com.drucare.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/hello")
	public Boolean insertOrUpdateEmployee(@RequestBody InsertOrUpdate insertOrUpdateEmployee) {
		return employeeService.insertOrUpdateEmployee(insertOrUpdateEmployee);



	}
}
