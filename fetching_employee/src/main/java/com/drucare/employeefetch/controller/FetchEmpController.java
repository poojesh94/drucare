package com.drucare.employeefetch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.drucare.employeefetch.bean.FetchEmployeeDto;
import com.drucare.employeefetch.bean.FetchEmployeeReq;
import com.drucare.employeefetch.service.FetchEmpService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@ApiResponses(value = {
		@ApiResponse(code=401, message="You are not authority to view resources"),
		@ApiResponse(code=403, message="Accesing the resource your write trying to reach is forbidden"),
		@ApiResponse(code=404, message="The resource you write trying to reach is not found"),
		@ApiResponse(code=400, message="Bad Request"),
		@ApiResponse(code=500, message="Internal Server error"),
})
@RestController
public class FetchEmpController {

	@Autowired
	FetchEmpService fetchEmpService;
	@ApiOperation(value = "This api is for fetch employee details")
	@GetMapping("/fetchEmployeeByUsingObject")
	public String fetchemployeeobject(@RequestBody FetchEmployeeReq fetchEmployeeReq) {
		return fetchEmpService.fetchemployeeobject(fetchEmployeeReq);
	}
	
	@ApiOperation(value = "This api is for fetch employee details")
	@GetMapping("/fetchEmployeeByUsingMap")
	public FetchEmployeeDto fetchEmployeeByUsingMap(@RequestBody FetchEmployeeReq fetchEmployeeReq) {
		return fetchEmpService.fetchEmployeeByUsingMap(fetchEmployeeReq);
	}
	
	@ApiOperation(value = "This api is for fetch employee details")
	@GetMapping("/fetchEmployeeByUsingList")
	public List<FetchEmployeeDto> fetchEmployeeByUsingList(@RequestBody FetchEmployeeReq fetchEmployeeReq) {
		return fetchEmpService.fetchEmployeeByUsingList(fetchEmployeeReq);
	}
	
	@ApiOperation(value = "This api is for fetch employee details")
	@GetMapping("/fetchEmployeeByUsingDetails")
	public List<FetchEmployeeDto> fetchEmployeeDetails(@RequestBody FetchEmployeeReq fetchEmployeeReq) {
		return fetchEmpService.fetchEmployeeDetails(fetchEmployeeReq);
	}
	
	@ApiOperation(value = "This api is for fetch employee details")
	@GetMapping("/fetchEmployeeDetails")
	public List<FetchEmployeeDto> fetchEmployeesDetails(@RequestBody FetchEmployeeReq fetchEmployeeReq){
		return fetchEmpService.fetchEmployeesDetails(fetchEmployeeReq);
	}
	
}
