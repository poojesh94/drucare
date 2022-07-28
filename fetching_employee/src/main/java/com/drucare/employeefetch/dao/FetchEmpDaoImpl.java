package com.drucare.employeefetch.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.drucare.employeefetch.bean.EmployeeDeptBean;
import com.drucare.employeefetch.bean.EmployeeDeptXref;
import com.drucare.employeefetch.bean.EmployeeDesignationBean;
import com.drucare.employeefetch.bean.EmployeeDesignationXref;
import com.drucare.employeefetch.bean.FetchEmployeeDto;
import com.drucare.employeefetch.bean.FetchEmployeeReq;

@Repository
public class FetchEmpDaoImpl implements FetchEmpDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public String fetchemployeeobject(FetchEmployeeReq fetchEmployeeReq) {

		String queryForFetchEmpbyObject = "Select concat(first_nm,'',middle_nm,'',last_nm) from employees_info_ref where emp_id=:empId and org_id=:orgId and is_active=true";
		return namedParameterJdbcTemplate.queryForObject(queryForFetchEmpbyObject,
				new BeanPropertySqlParameterSource(fetchEmployeeReq), String.class);
	}

	@Override
	public FetchEmployeeDto fetchEmployeeByUsingMap(FetchEmployeeReq fetchEmployeeReq) {
		FetchEmployeeDto fetchEmployeeDto = new FetchEmployeeDto();

		String queryForFetchEmployeeByUsingMap = "Select first_nm,middle_nm,last_nm,city_nm,state_nm,country_nm from employees_info_ref where emp_id=:empId and org_id=:orgId and is_active=true";

		Map<String, Object> map = namedParameterJdbcTemplate.queryForMap(queryForFetchEmployeeByUsingMap,
				new BeanPropertySqlParameterSource(fetchEmployeeReq));

		fetchEmployeeDto.setFirstNm((String) map.get("first_nm"));
		fetchEmployeeDto.setMiddleNm((String) map.get("middle_nm"));
		fetchEmployeeDto.setLastNm((String) map.get("last_nm"));
		fetchEmployeeDto.setCityNm((String) map.get("city_nm"));
		fetchEmployeeDto.setStateNm((String) map.get("state_nm"));
		fetchEmployeeDto.setCountryNm((String) map.get("country_nm"));

		return fetchEmployeeDto;
	}

	@Override
	public List<FetchEmployeeDto> fetchEmployeeByUsingList(FetchEmployeeReq fetchEmployeeReq) {
		List<FetchEmployeeDto> fetchEmployeeList = new ArrayList<>();
		FetchEmployeeDto fetchEmployeeDto = null;
		String queryForFetchEmployeeByUsingList = "SELECT CONCAT(first_nm,' ',middle_nm,' ',last_nm)empNm,eir.first_nm,eir.middle_nm,eir.last_nm,eir.gender,eir.moblie,eir.alter_mobile_no,eir.salary,eir.email_id,eir.emp_code,eir.address_line1,eir.address_line2,eir.state_nm,eir.city_nm,eir.country_nm,eir.pin_code,eir.qualification,eir.experience, dr.dept_nm,ds.designation_nm,edx.emp_id,edsx.designation_id FROM employees_info_ref eir JOIN employees_dept_xref edx ON edx.emp_id=eir.emp_id JOIN employee_designation_xref edsx ON edsx.emp_id=eir.emp_id JOIN deaprtment_ref ds ON dr.dept_id=edx.dept_id JOIN designation_ref ds ON ds.desgnation_id=edsx.designation";

		StringBuilder query = new StringBuilder(queryForFetchEmployeeByUsingList);

		if ((StringUtils.isNoneBlank(fetchEmployeeReq.getEmpNm()))) {
			query.append(" AND concat(first_nm,middle_nm,last_nm) ilike '%' ||:empNm||'%' ");

		}

		if ((StringUtils.isNoneBlank(fetchEmployeeReq.getMobileNo()))) {
			query.append(" and mobile_no=:mobileNo");
		}
		query.append("  order by emp_id desc ");
		List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(query.toString(),
				new BeanPropertySqlParameterSource(fetchEmployeeReq));
		if (CollectionUtils.isNotEmpty(rows)) {
			for (Map<String, Object> row : rows) {
				fetchEmployeeDto = new FetchEmployeeDto();

				fetchEmployeeDto.setFirstNm((String) row.get("first_nm"));
				fetchEmployeeDto.setMiddleNm((String) row.get("middle_nm"));
				fetchEmployeeDto.setLastNm((String) row.get("last_nm"));
				fetchEmployeeDto.setCityNm((String) row.get("city_nm"));
				fetchEmployeeDto.setStateNm((String) row.get("state_nm"));
				fetchEmployeeDto.setCountryNm((String) row.get("country_nm"));

				fetchEmployeeList.add(fetchEmployeeDto);
			}
		}

		return fetchEmployeeList;
	}

	@Override
	public List<FetchEmployeeDto> fetchEmployeeDetails(FetchEmployeeReq fetchEmployeeReq) {
		String queryForFetchEmployeeByUsingList = "Select first_nm,middle_nm,last_nm,city_nm,state_nm,country_nm from employees_info_ref where emp_id=:empId and org_id=:orgId and is_active=true";
		return namedParameterJdbcTemplate.query(queryForFetchEmployeeByUsingList,
				new BeanPropertySqlParameterSource(fetchEmployeeReq),
				new BeanPropertyRowMapper<FetchEmployeeDto>(FetchEmployeeDto.class));
	}


	@Override
	public List<FetchEmployeeDto> fetchEmployeesDetails(FetchEmployeeReq fetchEmployeeReq) {

		String fetchAllEmployeeDetails = "SELECT CONCAT(first_nm,' ',middle_nm,' ',last_nm)empNm,eir.first_nm,eir.middle_nm,eir.last_nm,eir.gender,eir.moblie_no,eir.alter_mobile_no,eir.salary,eir.email_id,eir.emp_code,eir.address_line1,eir.address_line2,eir.state_nm,eir.city_nm,eir.country_nm,eir.pin_code,eir.qualification,eir.experience, dr.dept_nm,ds.designation_nm,edx.emp_id,edsx.designation_id FROM employees_info_ref eir JOIN employee_dept_xref edx ON edx.emp_id=eir.emp_id JOIN employee_designation_xref edsx ON edsx.emp_id=eir.emp_id JOIN department_ref dr ON dr.dept_id=edx.dept_id JOIN designation_ref ds ON ds.designation_id=edsx.designation_id";

		FetchEmployeeDto fetchEmployeeDto = null;

		List<FetchEmployeeDto> fetchEmployeeDeatilsDtoList = new ArrayList<>();
		List<EmployeeDeptBean> employeeDepartmentList = null;
		List<EmployeeDesignationBean> employeeDesignationList = null;

		List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(fetchAllEmployeeDetails,
				new BeanPropertySqlParameterSource(fetchEmployeeReq));

		Set<Long> set = new HashSet<>();

		int count = 0;

		for (Map<String, Object> row : rows) {

			count++;

			if (set.add((Long) row.get("emp_id"))) {

				if (fetchEmployeeDto != null) {

					if (CollectionUtils.isNotEmpty(employeeDepartmentList)) {

						fetchEmployeeDto.setDepartmentList(employeeDepartmentList);

					}
					if (CollectionUtils.isNotEmpty(employeeDesignationList)) {
						fetchEmployeeDto.setDesignationList(employeeDesignationList);

					}
					fetchEmployeeDeatilsDtoList.add(fetchEmployeeDto);

				}

				fetchEmployeeDto = new FetchEmployeeDto();
				fetchEmployeeDto.setEmpId((Long) row.get("emp_id"));
				fetchEmployeeDto.setLastNm((String) row.get("last_nm"));
				fetchEmployeeDto.setFirstNm((String) row.get("first_nm"));
				fetchEmployeeDto.setMiddleNm((String) row.get("middle_nm"));
				fetchEmployeeDto.setMobileNo((String) row.get("mobile_no"));
				fetchEmployeeDto.setEmpCode((String) row.get("emp_code"));
				fetchEmployeeDto.setCountryNm((String) row.get("country_nm"));
				fetchEmployeeDto.setStateNm((String) row.get("state_nm"));
				employeeDepartmentList = new ArrayList<>();
				employeeDesignationList = new ArrayList<>();
			}
			if (row.get("dept_id") != null) {

				EmployeeDeptBean employeeDeptBean = new EmployeeDeptBean();
				employeeDeptBean.setDeptId((Long) row.get("dept_id"));

				EmployeeDeptXref fechEmpDeptBean = new EmployeeDeptXref();
				fechEmpDeptBean.setEmpDeptId((Long) row.get("emp_dept_id"));
				fechEmpDeptBean.setDeptId((Long) row.get("dept_id"));
				fetchEmployeeDto.setEmpId((Long) row.get("emp_id"));
				employeeDepartmentList.add(employeeDeptBean);

			}

			if (row.get("designation_id") != null) {
				EmployeeDesignationBean employeeDesignationBean = new EmployeeDesignationBean();
				employeeDesignationBean.setDesignationId((Long) row.get("designation_id"));

				EmployeeDesignationXref fetchEmpDesignationBean = new EmployeeDesignationXref();
				fetchEmpDesignationBean.setDesignationId((Long) row.get("emp_designation_id"));
				fetchEmpDesignationBean.setDesignationId((Long) row.get("designation_id"));
				fetchEmpDesignationBean.setOrgId((Long) row.get("org_id"));
				employeeDesignationList.add(employeeDesignationBean);
			}
		}

		if (count == rows.size() && fetchEmployeeDto != null) {

			fetchEmployeeDto.setDesignationList(employeeDesignationList);
			fetchEmployeeDto.setDepartmentList(employeeDepartmentList);
		}

		fetchEmployeeDeatilsDtoList.add(fetchEmployeeDto);

		if (count == rows.size() && fetchEmployeeDto != null) {
			if (CollectionUtils.isNotEmpty(employeeDepartmentList)) {

				fetchEmployeeDto.setDepartmentList(employeeDepartmentList);
			}
			if (CollectionUtils.isNotEmpty(employeeDesignationList)) {
				fetchEmployeeDto.setDesignationList(employeeDesignationList);
			}
			fetchEmployeeDeatilsDtoList.add(fetchEmployeeDto);
		}
		return fetchEmployeeDeatilsDtoList;
	}

}