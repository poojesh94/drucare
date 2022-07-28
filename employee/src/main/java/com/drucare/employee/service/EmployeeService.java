package com.drucare.employee.service;

import org.springframework.stereotype.Service;

import com.drucare.employee.demo.InsertOrUpdate;

@Service
public interface EmployeeService {

	Boolean insertOrUpdateEmployee(InsertOrUpdate insertOrUpdateEmployee);

}
