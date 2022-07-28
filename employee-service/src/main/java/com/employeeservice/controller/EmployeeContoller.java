package com.employeeservice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employeeservice.model.Employee;
import com.employeeservice.service.EmployeeService;


@RestController
public class EmployeeContoller{
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/employees",method = RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value = "/employees/{id}",method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") Long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	
	@RequestMapping(value = "/employees",method = RequestMethod.POST)
	public void createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
	}
	
	@RequestMapping(value="/employees/{id}",method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable("id") Long employeeId,@RequestBody Employee employee) {
		employeeService.updateEmployee(employeeId,employee);
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
}