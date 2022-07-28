package com.drucare.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.drucare.employee.demo.InsertOrUpdate;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;



	@Override
	public Boolean insertEmployee(InsertOrUpdate insertOrUpdateEmployee) {
		KeyHolder holder = new GeneratedKeyHolder();
		boolean flag=false;
		String queryInsertEmployeeDetails = "INSERT INTO employees_info_ref(first_nm,middle_nm,last_nm,gender,mobile_no,alter_mobile_no,salary,email_id,emp_code,address_line1,address_line2,state_nm,city_nm,country_nm,pin_code,qualification,experience,is_active) values(:firstNm,:middleNm,:lastNm,:gender,:mobileNo,:alterMobileNo,:salary,:emailId,:empCode,:addressLine1,:addressLine2,:stateNm,:cityNm,:countryNm,:pinCode,:qualification,:experience,:isActive)";



		flag = namedParameterJdbcTemplate.update(queryInsertEmployeeDetails,
				new BeanPropertySqlParameterSource(insertOrUpdateEmployee))>0;
		Long key=holder.getKey().longValue();
		insertOrUpdateEmployee.setEmpId(key);

				return flag;
	}

	@Override
	public Boolean updateEmployee(InsertOrUpdate insertOrUpdateEmployee) {
		//KeyHolder holder = new GeneratedKeyHolder();

		boolean flag=false;
		//EmployeeDaoImpl empDao=new EmployeeDaoImpl();
		//result=empDao.insertEmployee(insertOrUpdateEmployee);
		String queryForUpdateEmployeeDetails = "UPDATE employees_info_ref SET first_nm=:firstNm,middle_nm=:middleNm,last_nm=:lastNm,mobile_no=:mobileNo,email_id=:emailId,address_line1=:addressLine1,address_line2=:addressLine2 WHERE emp_id=:empId and is_active=true";

		flag=namedParameterJdbcTemplate.update(queryForUpdateEmployeeDetails,
				new BeanPropertySqlParameterSource(insertOrUpdateEmployee))>0;

		return flag;

	}

}
