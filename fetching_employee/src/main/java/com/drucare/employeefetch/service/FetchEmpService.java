package com.drucare.employeefetch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drucare.employeefetch.bean.FetchEmployeeDto;
import com.drucare.employeefetch.bean.FetchEmployeeReq;


@Service
public interface FetchEmpService {

	

	String fetchemployeeobject(FetchEmployeeReq fetchEmployeeReq);

	FetchEmployeeDto fetchEmployeeByUsingMap(FetchEmployeeReq fetchEmployeeReq);

	List<FetchEmployeeDto> fetchEmployeeByUsingList(FetchEmployeeReq fetchEmployeeReq);

	List<FetchEmployeeDto> fetchEmployeeDetails(FetchEmployeeReq fetchEmployeeReq);

	List<FetchEmployeeDto> fetchEmployeesDetails(FetchEmployeeReq fetchEmployeeReq);

}
