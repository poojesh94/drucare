package com.drucare.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drucare.employee.dao.EmployeeDao;
import com.drucare.employee.demo.InsertOrUpdate;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public Boolean insertOrUpdateEmployee(InsertOrUpdate insertOrUpdateEmployee) {
		if(insertOrUpdateEmployee.getEmpId()==null) {
			return employeeDao.insertEmployee(insertOrUpdateEmployee);
		}else {
			return employeeDao.updateEmployee(insertOrUpdateEmployee);
		}
	}
}
