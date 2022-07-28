package com.resttemplate.service;

import com.resttemplate.bean.Employee;

public interface RestService {

	Boolean insertEmployeeDetails(Employee employee);

	Boolean updateEmployeeDetails(Employee employee);

}
