package com.example.Restaurant_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restaurant_Management_System.dto.Employee;
import com.example.Restaurant_Management_System.service.EmployeeService;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int oldId, @RequestBody Employee newEmployee) {
		return employeeService.updateEmployee(oldId, newEmployee);
	}

	@GetMapping("/fetchEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@RequestParam int Id) {
		return employeeService.fetchEmployeeById(Id);
	}

	@GetMapping("/fetchAllEmployee")
	public ResponseEntity<ResponseStructureList<Employee>> fetchAllEmployee() {
		return employeeService.fetchAllEmployee();
	}

	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@RequestParam int employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

}
