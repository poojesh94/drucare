package com.drucare.employeeinfo.service;

import org.springframework.stereotype.Service;

import com.drucare.employeeinfo.bean.Employee;

@Service
public interface EmployeeService {
	public Boolean insertEmployeeDetails(Employee insertEmployeeDetailsReq);
	public Boolean insertEmployeeDetailsByMapSql(Employee insertEmployeeDetailsByMapSql);
	public Boolean insertEmployeeDetailsByBeanProperty(Employee insertEmployeeDetailsByBeanProperty);
	
	public Boolean updateEmployeeDetails(Employee updateEmployeeDetailsReq);
	public Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest);
	public Boolean updateEmployeeDetailsUsingBeanPropertyReq(Employee updateEmployeeDetailsUsingBeanPropertyReq);
	
}
