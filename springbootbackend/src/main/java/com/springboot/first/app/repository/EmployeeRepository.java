package com.springboot.first.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.first.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	

}
