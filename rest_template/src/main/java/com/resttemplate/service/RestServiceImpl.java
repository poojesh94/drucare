package com.resttemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.resttemplate.bean.Employee;

@Service
public class RestServiceImpl implements RestService {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Boolean insertEmployeeDetails(Employee employee) {
		return restTemplate.postForObject("http://localhost:9002/insertEmployeeDetails", employee, Boolean.class);
	}

	@Override
	public Boolean updateEmployeeDetails(Employee employee) {
		restTemplate.put("http://localhost:9002/updateEmployeeDetails", employee);
		return true;
	}

}
