package com.drucare.employeeinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drucare.employeeinfo.bean.Employee;
import com.drucare.employeeinfo.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Boolean insertEmployeeDetails(Employee insertEmployeeDetailsReq) {
		return employeeDao.insertEmployeeDetails(insertEmployeeDetailsReq);
	}

	@Override
	public Boolean insertEmployeeDetailsByMapSql(Employee insertEmployeeDetailsByMapSql) {
		return employeeDao.insertEmployeeDetailsByMapSql(insertEmployeeDetailsByMapSql);
	}

	@Override
	public Boolean insertEmployeeDetailsByBeanProperty(Employee insertEmployeeDetailsByBeanProperty) {
		return employeeDao.insertEmployeeDetailsByBeanProperty(insertEmployeeDetailsByBeanProperty);
	}

	@Override
	public Boolean updateEmployeeDetails(Employee updateEmployeeDetailsReq) {

		return employeeDao.updateEmployeeDetails(updateEmployeeDetailsReq);
	}

	@Override
	public Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest) {
		return employeeDao.updateEmployeeDetailsUsingSqlParameterSource(updateEmployeeRequest);
	}

	@Override
	public Boolean updateEmployeeDetailsUsingBeanPropertyReq(Employee updateEmployeeDetailsUsingBeanPropertyReq) {
		return employeeDao.insertEmployeeDetailsByBeanProperty(updateEmployeeDetailsUsingBeanPropertyReq);
	}

}
