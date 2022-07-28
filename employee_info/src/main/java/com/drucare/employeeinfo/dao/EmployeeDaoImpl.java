package com.drucare.employeeinfo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.drucare.employeeinfo.bean.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Boolean insertEmployeeDetails(Employee insertEmployeeDetailsReq) {
		boolean flag = false;
		String queryInsertEmployeeDetails = "INSERT INTO employees_info_ref(first_nm,middle_nm,last_nm,gender,moblie_no,alter_mobile_no,salary,email_id,emp_code,address_line1,address_line2,state_nm,city_nm,country_nm,pin_code,qualification,experience,isactive) values(:firstNm,:middleNm,:lastNm,:gender,:moblieNo,:alterMobileNo,:salary,:emailId,:empCode,:addressLine1,:addressLine2,:stateNm,:cityNm,:countryNm,:pinCode,:qualification,:experience,:isactive)";

		try {
			Map<String, Object> mapInsert = new HashMap<>();

			mapInsert.put("firstNm", insertEmployeeDetailsReq.getFirstNm());
			mapInsert.put("middleNm", insertEmployeeDetailsReq.getMiddleNm());
			mapInsert.put("lastNm", insertEmployeeDetailsReq.getLastNm());
			mapInsert.put("gender", insertEmployeeDetailsReq.getGender());
			mapInsert.put("moblieNo", insertEmployeeDetailsReq.getMoblieNo());
			mapInsert.put("alterMobileNo", insertEmployeeDetailsReq.getAlterMobileNo());
			mapInsert.put("emailId", insertEmployeeDetailsReq.getEmailId());
			mapInsert.put("empCode", insertEmployeeDetailsReq.getEmpCode());
			mapInsert.put("addressLine1", insertEmployeeDetailsReq.getAddressLine1());
			mapInsert.put("addressLine2", insertEmployeeDetailsReq.getAddressLine2());
			mapInsert.put("stateNm", insertEmployeeDetailsReq.getStateNm());
			mapInsert.put("cityNm", insertEmployeeDetailsReq.getCityNm());
			mapInsert.put("countryNm", insertEmployeeDetailsReq.getCountryNm());
			mapInsert.put("pinCode", insertEmployeeDetailsReq.getPinCode());
			mapInsert.put("salary", insertEmployeeDetailsReq.getSalary());
			mapInsert.put("qualification", insertEmployeeDetailsReq.getQualification());
			mapInsert.put("experience", insertEmployeeDetailsReq.getExperience());
			mapInsert.put("isactive", insertEmployeeDetailsReq.getIsactive());

			flag = namedParameterJdbcTemplate.update(queryInsertEmployeeDetails, mapInsert) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Boolean insertEmployeeDetailsByMapSql(Employee insertEmployeeDetailsByMapSql) {
		boolean flag = false;
		String queryInsertEmployeeDetails = "insert into employees_info_ref (first_nm,middle_nm,last_nm,gender,mobile_no,alter_moblie_no,email_id,emp_code,address_line1,address_line2,state_nm,city_nm,country_nm,pin_code,salary,qualification,experience,isactive) VALUES (:firstNm,:middleNm,:lastNm,:gender,:moblieNo,:alterMobileNo,:emailId,:empCode,:addressLine1,:addressLine2,:stateNm,:cityNm,:countryNm,:pinCode,:salary,:qualification,:experience,:isactive)";
		try {
			MapSqlParameterSource insertMapSql = new MapSqlParameterSource()
					.addValue("firstNa", insertEmployeeDetailsByMapSql.getFirstNm())
					.addValue("middleNm", insertEmployeeDetailsByMapSql.getMiddleNm())
					.addValue("lastNm", insertEmployeeDetailsByMapSql.getLastNm())
					.addValue("gender", insertEmployeeDetailsByMapSql.getGender())
					.addValue("moblieNo", insertEmployeeDetailsByMapSql.getMoblieNo())
					.addValue("alterMobileNo", insertEmployeeDetailsByMapSql.getAlterMobileNo())
					.addValue("emailId", insertEmployeeDetailsByMapSql.getEmailId())
					.addValue("empCode", insertEmployeeDetailsByMapSql.getEmpCode())
					.addValue("addressLine1", insertEmployeeDetailsByMapSql.getAddressLine1())
					.addValue("addressLine2", insertEmployeeDetailsByMapSql.getAddressLine2())
					.addValue("stateNm", insertEmployeeDetailsByMapSql.getStateNm())
					.addValue("cityNm", insertEmployeeDetailsByMapSql.getCityNm())
					.addValue("countryNm", insertEmployeeDetailsByMapSql.getCountryNm())
					.addValue("pinCode", insertEmployeeDetailsByMapSql.getPinCode())
					.addValue("salary", insertEmployeeDetailsByMapSql.getSalary())
					.addValue("qualification", insertEmployeeDetailsByMapSql.getQualification())
					.addValue("experience", insertEmployeeDetailsByMapSql.getExperience())
					.addValue("isactive", insertEmployeeDetailsByMapSql.getIsactive());

			flag = namedParameterJdbcTemplate.update(queryInsertEmployeeDetails, insertMapSql) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Boolean insertEmployeeDetailsByBeanProperty(Employee insertEmployeeDetailsByBeanProperty) {
		boolean flag = false;
		String queryinsertEmployeeDetailsByBeanProperty = "INSERT INTO employees_info_ref (first_nm,middle_nm,last_nm,gender,moblie_no,alter_mobile_no,email_id,emp_code,address_line1,address_line2,state_nm,city_nm,country_nm,pin_code,salary,qualification,experience,isactive) VALUES (:firstNm,:middleNm,:lastNm,:gender,:moblieNo,:alterMobileNo,:emailId,:empCode,:addressLine1,:addressLine2,:stateNm,:cityNm,:countryNm,:pinCode,:salary,:qualification,:experience,:isactive)";
		try {
			flag = namedParameterJdbcTemplate.update(queryinsertEmployeeDetailsByBeanProperty,
					new BeanPropertySqlParameterSource(insertEmployeeDetailsByBeanProperty)) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Boolean updateEmployeeDetails(Employee updateEmployeeDetailsReq) {
		// String queryToUpdateEmployeeDetails="update employees_info_ref
		// first_nm,middle_nm,last_nm,gender,mobile_no,alter_mobile_no,salary,email_id,emp_code,address_line1,address_line2,state_nm,city_nm,country_nm,pin_code,qualification,experience,is_active
		// where emp_id= :empId";

		String queryToUpdateEmployeeDetails = "update employees_info_ref set first_nm=:firstNm,middle_nm=:middleNm,last_nm=:lastNm,gender=:gender,moblie_no=:moblieNo,alter_mobile_no=:alterMobileNo,email_id=:emailId,emp_code=:empCode,address_line1=:addressLine1,address_line2=:addressLine2,state_nm=:stateNm,city_nm=:cityNm,country_nm=:countryNm,pin_code=:pinCode,salary=:salary,qualification=:qualification,experience=:experience,isactive=:isactive where emp_id=:empId";

		Map<String, Object> parameters = new HashMap<>();

		parameters.put("empId", updateEmployeeDetailsReq.getEmpId());

		parameters.put("firstNm", updateEmployeeDetailsReq.getFirstNm());

		parameters.put("middleNm", updateEmployeeDetailsReq.getMiddleNm());

		parameters.put("lastNm", updateEmployeeDetailsReq.getLastNm());

		parameters.put("gender", updateEmployeeDetailsReq.getGender());

		parameters.put("moblieNo", updateEmployeeDetailsReq.getMoblieNo());

		parameters.put("alterMobileNo", updateEmployeeDetailsReq.getAlterMobileNo());

		parameters.put("emailId", updateEmployeeDetailsReq.getEmailId());

		parameters.put("empCode", updateEmployeeDetailsReq.getEmpCode());

		parameters.put("addressLine1", updateEmployeeDetailsReq.getAddressLine1());

		parameters.put("addressLine2", updateEmployeeDetailsReq.getAddressLine2());

		parameters.put("stateNm", updateEmployeeDetailsReq.getStateNm());

		parameters.put("cityNm", updateEmployeeDetailsReq.getCityNm());

		parameters.put("countryNm", updateEmployeeDetailsReq.getCountryNm());

		parameters.put("qualification", updateEmployeeDetailsReq.getQualification());

		parameters.put("pinCode", updateEmployeeDetailsReq.getPinCode());

		parameters.put("salary", updateEmployeeDetailsReq.getSalary());

		parameters.put("experience", updateEmployeeDetailsReq.getExperience());

		parameters.put("isactive", updateEmployeeDetailsReq.getIsactive());

		boolean result = false;

		try {

			result = namedParameterJdbcTemplate.update(queryToUpdateEmployeeDetails, parameters) > 0;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;

	}

	@Override
	public Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest) {
		String queryToUpdateEmployeeDetails = "update employees_info_ref set first_nm=:firstNm, middle_nm=:middleNm,last_nm=:lastNm,gender=:gender, moblie_no = :moblieNo,alter_mobile_no=:alterMobileNo,email_id=:emailId,emp_code=:empCode,address_line1=:addressLine1,address_line2=:addressLine2,state_nm=:stateNm,city_nm=:cityNm,country_nm=:countryNm,pin_code=:pinCode,salary=:salary,qualification=:qualification,experience=:experience,isactive=:isactive where emp_id =:empId";
		MapSqlParameterSource map = new MapSqlParameterSource();

		map.addValue("empId", updateEmployeeRequest.getEmpId());
		map.addValue("firstNm", updateEmployeeRequest.getFirstNm());
		map.addValue("middleNm", updateEmployeeRequest.getMiddleNm());
		map.addValue("lastNm", updateEmployeeRequest.getLastNm());
		map.addValue("gender", updateEmployeeRequest.getGender());
		map.addValue("moblieNo", updateEmployeeRequest.getMoblieNo());
		map.addValue("alterMobileNo", updateEmployeeRequest.getAlterMobileNo());
		map.addValue("emailId", updateEmployeeRequest.getEmailId());
		map.addValue("empCode", updateEmployeeRequest.getEmpCode());
		map.addValue("addressLine1", updateEmployeeRequest.getAddressLine1());
		map.addValue("addressLine2", updateEmployeeRequest.getAddressLine2());
		map.addValue("stateNm", updateEmployeeRequest.getStateNm());
		map.addValue("cityNm", updateEmployeeRequest.getCityNm());
		map.addValue("countryNm", updateEmployeeRequest.getCountryNm());
		map.addValue("pinCode", updateEmployeeRequest.getPinCode());
		map.addValue("salary", updateEmployeeRequest.getSalary());
		map.addValue("qualification", updateEmployeeRequest.getQualification());
		map.addValue("experience", updateEmployeeRequest.getExperience());
		map.addValue("isactive", updateEmployeeRequest.getIsactive());

		return namedParameterJdbcTemplate.update(queryToUpdateEmployeeDetails, map) > 0;
	}
	@Override
	public Boolean updateEmployeeDetailsUsingBeanPropertyReq(Employee updateEmployeeDetailsUsingBeanPropertyReq) {
		String queryToUpdateEmployeeDetails = "update employees_info_ref set first_nm=:firstNm, middle_nm=:middleNm,last_nm=:lastNm,gender=:gender, moblie_no = :moblieNo,alter_mobile_no=:alterMobileNo,email_id=:emailId,emp_code=:empCode,address_line1=:addressLine1,address_line2=:addressLine2,state_nm=:stateNm,city_nm=:cityNm,country_nm=:countryNm,pin_code=:pinCode,salary=:salary,qualification=:qualification,experience=:experience,isactive=:isactive where emp_id =:empId";
		return namedParameterJdbcTemplate.update(queryToUpdateEmployeeDetails, new BeanPropertySqlParameterSource(updateEmployeeDetailsUsingBeanPropertyReq))>0;
	}

}
