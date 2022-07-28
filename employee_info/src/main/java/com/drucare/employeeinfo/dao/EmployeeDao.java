package com.drucare.employeeinfo.dao;

import org.springframework.stereotype.Repository;

import com.drucare.employeeinfo.bean.Employee;

@Repository
public interface EmployeeDao {
	public Boolean insertEmployeeDetails(Employee insertEmployeeDetailsReq);
	public Boolean insertEmployeeDetailsByMapSql(Employee insertEmployeeDetailsByMapSql);
	public Boolean insertEmployeeDetailsByBeanProperty(Employee insertEmployeeDetailsByBeanProperty);
	
	public Boolean updateEmployeeDetails(Employee updateEmployeeDetailsReq);
    public	Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest);
	public Boolean updateEmployeeDetailsUsingBeanPropertyReq(Employee updateEmployeeDetailsUsingBeanPropertyReq);


}
