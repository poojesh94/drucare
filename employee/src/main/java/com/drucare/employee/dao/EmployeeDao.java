package com.drucare.employee.dao;

import org.springframework.stereotype.Repository;

import com.drucare.employee.demo.InsertOrUpdate;

@Repository
public interface EmployeeDao {

	Boolean insertEmployee(InsertOrUpdate insertOrUpdateEmployee);

	Boolean updateEmployee(InsertOrUpdate insertOrUpdateEmployee);

}
