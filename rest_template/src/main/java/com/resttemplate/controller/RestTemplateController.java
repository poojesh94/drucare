package com.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resttemplate.bean.Employee;
import com.resttemplate.service.RestService;

@RestController
public class RestTemplateController {
		@Autowired
		private RestService restService;
		
		@PostMapping("/insertEmployeeDetails")
		public Boolean insertEmployeeDetails(@RequestBody Employee employee) {
			return restService.insertEmployeeDetails(employee);
		}
		
		@PutMapping("/updateEmployee")
		public Boolean updateEmployeeDetails(@RequestBody Employee employee) {
			return restService.updateEmployeeDetails(employee);
		}
}
