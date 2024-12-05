package com.example.Restaurant_Management_System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Restaurant_Management_System.dto.Address;
import com.example.Restaurant_Management_System.dto.Branch;
import com.example.Restaurant_Management_System.dto.Customer;
import com.example.Restaurant_Management_System.dto.Employee;
import com.example.Restaurant_Management_System.dto.FoodOrder;
import com.example.Restaurant_Management_System.dto.Manager;
import com.example.Restaurant_Management_System.dto.Menu;
import com.example.Restaurant_Management_System.dto.Owner;
import com.example.Restaurant_Management_System.dto.Restaurant;
import com.example.Restaurant_Management_System.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseEntity<ResponseStructure<Owner>> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>();
		responseStructure.setMessage("Owner Id NOT FOUND");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(RestaurantIdNotFound.class)
	public ResponseEntity<ResponseStructure<Restaurant>> restaurantIdNotFound(
			RestaurantIdNotFound restaurantIdNotFound) {
		ResponseStructure<Restaurant> responseStructure = new ResponseStructure<Restaurant>();
		responseStructure.setMessage("Restaurant Id NOT FOUND");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<Branch>> branchIdNotFound(BranchIdNotFound branchIdNotFound) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		responseStructure.setMessage("Branch Id NOT FOUND");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseEntity<ResponseStructure<Manager>> managerIdNotFound(ManagerIdNotFound managerIdNotFound) {
		ResponseStructure<Manager> responseStructure = new ResponseStructure<Manager>();
		responseStructure.setMessage("Manager Id NOT FOUND");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseEntity<ResponseStructure<Employee>> employeeIdNotFound(EmployeeIdNotFound employeeIdNotFound) {
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setMessage("Employee Id NOT FOUND");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MenuIdNotFound.class)
	public ResponseEntity<ResponseStructure<Menu>> menuIdNotFound(MenuIdNotFound menuIdNotFound) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		responseStructure.setMessage("Menu Id NOT FOUND");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<Address>> addressIdNotFound(AddressIdNotFound addressIdNotFound) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		responseStructure.setMessage("Address Id NOT FOUND");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseEntity<ResponseStructure<Customer>> customerIdNotFound(CustomerIdNotFound customerIdNotFound) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setMessage("Customer Id NOT FOUND");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(FoodOrderIdNotFound.class)
	public ResponseEntity<ResponseStructure<FoodOrder>> foodOrderIdNotFound(FoodOrderIdNotFound foodOrderIdNotFound) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		responseStructure.setMessage("FoodOrder Id NOT FOUND");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.NOT_FOUND);

	}

}
