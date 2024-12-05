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

import com.example.Restaurant_Management_System.dto.Customer;
import com.example.Restaurant_Management_System.dto.FoodOrder;
import com.example.Restaurant_Management_System.service.CustomerService;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestParam int oldId, @RequestBody Customer newCustomer) {
		return customerService.updateCustomer(oldId, newCustomer);
	}

	@GetMapping("/fetchCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(@RequestParam int Id) {
		return customerService.fetchCustomerById(Id);
	}

	@GetMapping("/fetchAllCustomer")
	public ResponseEntity<ResponseStructureList<Customer>> fetchAllCustomer() {
		return customerService.fetchAllCustomer();
	}

	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam int customerId) {
		return customerService.deleteCustomer(customerId);
	}
//-----------------------------------[FoodOrder OtM]------------------------------------------------

	@PutMapping("/addExistingFoodOrderToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addExistingFoodOrderToExistingCustomer(@RequestParam int customerId,@RequestParam int foodOrderId) {
		return customerService.addExistingFoodOrderToExistingCustomer(customerId, foodOrderId);
	}

	@PutMapping("/addNewFoodOrderToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addNewFoodOrderToExistingCustomer(@RequestParam int customerId ,@RequestBody FoodOrder newfoodOrder) {
		return customerService.addNewFoodOrderToExistingCustomer(customerId, newfoodOrder);
	}

	
}
