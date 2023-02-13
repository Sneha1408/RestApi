package com.springboot.first.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.stereotype.Service;

import com.springboot.first.app.exception.ResourceNotFoundException;
import com.springboot.first.app.model.Employee;
import com.springboot.first.app.repository.EmployeeRepository;
import com.springboot.first.app.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAllEmployees()

	{
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById(long id)
	{
		return employeeRepository.findById(id).orElseThrow(()->
		       new ResourceNotFoundException("Employee", "id", id));
		
	} 
   @Override
   
   public Employee updateEmployee(Employee employee, long id)
   {
	   Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->
       new ResourceNotFoundException("Employee", "id", id));
	   
	   existingEmployee.setFirst_name(employee.getFirst_name());
	   existingEmployee.setLast_name(employee.getLast_name());
	   existingEmployee.setEmail(employee.getEmail());
	   
	   // save existing employee into database
	   
	   return existingEmployee;
	   
	   

   }
   
   @Override
	public void deleteEmployee(long id) {
		
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}
	

}