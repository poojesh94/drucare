package com.drucare.employeefetch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drucare.employeefetch.bean.FetchEmployeeDto;
import com.drucare.employeefetch.bean.FetchEmployeeReq;
import com.drucare.employeefetch.dao.FetchEmpDao;

@Service
public class FetchEmpServiceImpl implements FetchEmpService {
	@Autowired
	FetchEmpDao fetchEmpDao;

	@Override
	public String fetchemployeeobject(FetchEmployeeReq fetchEmployeeReq) {
		// TODO Auto-generated method stub
		return fetchEmpDao.fetchemployeeobject(fetchEmployeeReq);
	}

	@Override
	public FetchEmployeeDto fetchEmployeeByUsingMap(FetchEmployeeReq fetchEmployeeReq) {
		return fetchEmpDao.fetchEmployeeByUsingMap(fetchEmployeeReq);
	}

	@Override
	public List<FetchEmployeeDto> fetchEmployeeByUsingList(FetchEmployeeReq fetchEmployeeReq) {
		// TODO Auto-generated method stub
		return fetchEmpDao.fetchEmployeeByUsingList(fetchEmployeeReq);
	}

	@Override
	public List<FetchEmployeeDto> fetchEmployeeDetails(FetchEmployeeReq fetchEmployeeReq) {
		// TODO Auto-generated method stub
		return fetchEmpDao.fetchEmployeeDetails(fetchEmployeeReq);
	}

	@Override
	public List<FetchEmployeeDto> fetchEmployeesDetails(FetchEmployeeReq fetchEmployeeReq) {
		// TODO Auto-generated method stub
		return fetchEmpDao.fetchEmployeesDetails(fetchEmployeeReq);
	}

}
