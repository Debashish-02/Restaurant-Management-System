package com.example.Restaurant_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Restaurant_Management_System.dao.EmployeeDao;
import com.example.Restaurant_Management_System.dto.Employee;
import com.example.Restaurant_Management_System.exception.EmployeeIdNotFound;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	ResponseStructure<Employee> responseStructure;
	@Autowired
	ResponseStructureList<Employee> responseStructureList;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		responseStructure.setMessage("Successfully Employee Inserted into the DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int oldId, Employee newEmployee) {
		Employee employee = employeeDao.fetchEmployeeById(oldId);
		if (employee != null) {
			responseStructure.setMessage("Successfully Employee Updated in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(int Id) {
		Employee employee = employeeDao.fetchEmployeeById(Id);
		if (employee != null) {
			responseStructure.setMessage("Successfully Employee Fetched from the DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setMessage("Successfully Employee Deleted from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Employee>> fetchAllEmployee() {
		responseStructureList.setMessage("Successfully Found All Employee from the DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		List<Employee> list = employeeDao.fetchAllEmployee();
		responseStructureList.setData(list);
		return new ResponseEntity<ResponseStructureList<Employee>>(responseStructureList, HttpStatus.FOUND);
	}

}
