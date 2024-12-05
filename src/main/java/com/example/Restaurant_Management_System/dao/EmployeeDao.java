package com.example.Restaurant_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Restaurant_Management_System.dto.Employee;
import com.example.Restaurant_Management_System.repo.EmployeeRepo;
@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee updateEmployee(int oldId ,Employee newEmployee) {
		newEmployee.setEmployeeId(oldId);
		return employeeRepo.save(newEmployee);
	}
	
	public Employee fetchEmployeeById(int Id) {
		Optional<Employee> employee= employeeRepo.findById(Id);
		if(employee.isPresent()) {return employee.get();}
		else {return null;}
	}

	
	public List<Employee> fetchAllEmployee() {
		return employeeRepo.findAll();
	}
	
	public Employee deleteEmployee(int employeeId) {
		Employee employee= fetchEmployeeById(employeeId);
		 employeeRepo.delete(employee);
		 return employee;
	}

}
