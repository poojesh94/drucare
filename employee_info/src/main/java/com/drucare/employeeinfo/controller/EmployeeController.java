package com.drucare.employeeinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.drucare.employeeinfo.bean.Employee;
import com.drucare.employeeinfo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/insertEmployeeDetails")
	public Boolean insertEmployeeDetails(@RequestBody Employee insertEmployeeDetailsReq) {
		return employeeService.insertEmployeeDetails(insertEmployeeDetailsReq);
	}
	
	@PostMapping("/insertEmployeeDetailsByMapSql")
	public Boolean insertEmployeeDetailsByMapSql(@RequestBody Employee insertEmployeeDetailsByMapSql) {
		return employeeService.insertEmployeeDetailsByMapSql(insertEmployeeDetailsByMapSql);
	}
	
	@PostMapping("/insertEmployeeDetailsByBeanProperty")
	public Boolean insertEmployeeDetailsByBeanProperty(@RequestBody Employee insertEmployeeDetailsByBeanProperty) {
		return employeeService.insertEmployeeDetailsByBeanProperty(insertEmployeeDetailsByBeanProperty);
	}
	@PutMapping("/updateEmployeeDetails")
	public Boolean updateEmployeeDetails(@RequestBody Employee updateEmployeeDetailsReq) {
		return employeeService.updateEmployeeDetails( updateEmployeeDetailsReq);
	}
	@PutMapping("/updateEmployeeDetailsUsingSqlParameterSource")
	Boolean updateEmployeeDetailsUsingSqlParameterSource(@RequestBody Employee updateEmployeeRequest) {
		return employeeService.updateEmployeeDetailsUsingSqlParameterSource(updateEmployeeRequest);
	}
	@PutMapping("/updateEmployeeDetailsUsingBeanProperty")
	Boolean updateEmployeeDetailsUsingBeanProperty(@RequestBody Employee updateEmployeeDetailsUsingBeanPropertyReq) {
		return employeeService.updateEmployeeDetailsUsingBeanPropertyReq(updateEmployeeDetailsUsingBeanPropertyReq);
	}

}
