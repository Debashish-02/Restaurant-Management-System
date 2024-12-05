package com.example.Restaurant_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Restaurant_Management_System.dao.CustomerDao;
import com.example.Restaurant_Management_System.dao.FoodOrderDao;
import com.example.Restaurant_Management_System.dto.Customer;
import com.example.Restaurant_Management_System.dto.FoodOrder;
import com.example.Restaurant_Management_System.exception.CustomerIdNotFound;
import com.example.Restaurant_Management_System.exception.FoodOrderIdNotFound;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	FoodOrderDao foodOrderDao;

	@Autowired
	ResponseStructure<Customer> responseStructure;
	@Autowired
	ResponseStructureList<Customer> responseStructureList;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		responseStructure.setMessage("Successfully Customer Inserted into the DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(int oldId, Customer newCustomer) {
		Customer customer = customerDao.fetchCustomerById(oldId);
		if (customer != null) {
			responseStructure.setMessage("Successfully Customer Updated in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(int Id) {
		Customer customer = customerDao.fetchCustomerById(Id);
		if (customer != null) {
			responseStructure.setMessage("Successfully Customer Fetched from the DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("Successfully Customer Deleted from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Customer>> fetchAllCustomer() {
		responseStructureList.setMessage("Successfully Found All Customer from the DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		List<Customer> list = customerDao.fetchAllCustomer();
		responseStructureList.setData(list);
		return new ResponseEntity<ResponseStructureList<Customer>>(responseStructureList, HttpStatus.FOUND);
	}

//-----------------------------------[FoodOrder OtM]------------------------------------------------

//	public ResponseEntity<ResponseStructure<Customer>> addExistingFoodOrderToExistingCustomer(int customerId,
//			int foodOrderId) {
//		responseStructure.setMessage("Successfully FoodOrder linked to Customer  in the DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(customerDao.addExistingFoodOrderToExistingCustomer(customerId, foodOrderId));
//		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
//	}
//
//	public ResponseEntity<ResponseStructure<Customer>> addNewFoodOrderToExistingCustomer(int customerId,
//			FoodOrder newfoodOrder) {
//		responseStructure.setMessage("Successfully New FoodOrder Added to Customer  inthe DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(customerDao.addNewFoodOrderToExistingCustomer(customerId, newfoodOrder));
//		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
//	}

	public ResponseEntity<ResponseStructure<Customer>> addExistingFoodOrderToExistingCustomer(int customerId,
			int foodOrderId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		if (customer == null) {
			throw new CustomerIdNotFound();
		} else if (foodOrder == null) {
			throw new FoodOrderIdNotFound();
		} else {
			responseStructure.setMessage("Successfully FoodOrder linked to Customer  in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.addExistingFoodOrderToExistingCustomer(customerId, foodOrderId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> addNewFoodOrderToExistingCustomer(int customerId,
			FoodOrder newfoodOrder) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("Successfully New FoodOrder Added to Customer  inthe DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.addNewFoodOrderToExistingCustomer(customerId, newfoodOrder));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}

}
