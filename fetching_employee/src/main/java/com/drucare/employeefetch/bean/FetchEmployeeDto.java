package com.drucare.employeefetch.bean;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class FetchEmployeeDto {
	@ApiModelProperty(value = "It indicates name of the employee")
	private Long empId;
	@ApiModelProperty(value = "It indicates first name of the employee")
	private String firstNm;
	@ApiModelProperty(value = "It indicates middle name of the employee")
	private String middleNm;
	@ApiModelProperty(value = "It indicates last name of the employee")
	private String lastNm;
	@ApiModelProperty(value = "It indicates gender of the employee")
	private String gender;
	@ApiModelProperty(value = "It indicates mobile number of the employee")
	private String mobileNo;
	@ApiModelProperty(value = "It indicates alter mobile number of the employee")
	private String alterMobileNo;
	@ApiModelProperty(value = "It indicates email id of the employee")
	private String emailId;
	@ApiModelProperty(value = "It indicates emp code of the employee")
	private String empCode;
	@ApiModelProperty(value = "It indicates address line 1 of the employee")
	private String addressLine1;
	@ApiModelProperty(value = "It indicates address line 2 of the employee")
	private String addressLine2;
	@ApiModelProperty(value = "It indicates state name of the employee")
	private String stateNm;
	@ApiModelProperty(value = "It indicates city name of the employee")
	private String cityNm;
	@ApiModelProperty(value = "It indicates country name of the employee")
	private String countryNm;
	@ApiModelProperty(value = "It indicates pin code of the employee")
	private String pinCode;
	@ApiModelProperty(value = "It indicates salary of the employee")
	private Double salary;
	@ApiModelProperty(value = "It indicates qualification of the employee")
	private String qualification;
	@ApiModelProperty(value = "It indicates experience of the employee")
	private String experience;
	@ApiModelProperty(value = "It indicates organisation id of the employee")
	private Long orgId;
	@ApiModelProperty(value = "It indicates list of departments of the employee")
	private List<EmployeeDeptBean> departmentList;
	@ApiModelProperty(value = "It indicates list of designation of the employee")
	private List<EmployeeDesignationBean> designationList;

	public List<EmployeeDeptBean> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<EmployeeDeptBean> departmentList) {
		this.departmentList = departmentList;
	}

	public List<EmployeeDesignationBean> getDesignationList() {
		return designationList;
	}

	public void setDesignationList(List<EmployeeDesignationBean> designationList) {
		this.designationList = designationList;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getFirstNm() {
		return firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getMiddleNm() {
		return middleNm;
	}

	public void setMiddleNm(String middleNm) {
		this.middleNm = middleNm;
	}

	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAlterMobileNo() {
		return alterMobileNo;
	}

	public void setAlterMobileNo(String alterMobileNo) {
		this.alterMobileNo = alterMobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getStateNm() {
		return stateNm;
	}

	public void setStateNm(String stateNm) {
		this.stateNm = stateNm;
	}

	public String getCityNm() {
		return cityNm;
	}

	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}

	public String getCountryNm() {
		return countryNm;
	}

	public void setCountryNm(String countryNm) {
		this.countryNm = countryNm;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
