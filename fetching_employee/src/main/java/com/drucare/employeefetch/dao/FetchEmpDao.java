package com.drucare.employeefetch.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drucare.employeefetch.bean.FetchEmployeeDto;
import com.drucare.employeefetch.bean.FetchEmployeeReq;

@Repository
public interface FetchEmpDao {

	String fetchemployeeobject(FetchEmployeeReq fetchEmployeeReq);

	FetchEmployeeDto fetchEmployeeByUsingMap(FetchEmployeeReq fetchEmployeeReq);

	List<FetchEmployeeDto> fetchEmployeeByUsingList(FetchEmployeeReq fetchEmployeeReq);

	List<FetchEmployeeDto> fetchEmployeeDetails(FetchEmployeeReq fetchEmployeeReq);

	List<FetchEmployeeDto> fetchEmployeesDetails(FetchEmployeeReq fetchEmployeeReq);

}
