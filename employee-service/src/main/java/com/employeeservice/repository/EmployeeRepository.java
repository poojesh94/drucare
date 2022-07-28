package com.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}