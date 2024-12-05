package com.example.Restaurant_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Restaurant_Management_System.dto.Customer;
import com.example.Restaurant_Management_System.dto.FoodOrder;
import com.example.Restaurant_Management_System.repo.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	FoodOrderDao foodOrderDao;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer updateCustomer(int oldId, Customer newCustomer) {
		newCustomer.setCustomerId(oldId);
		return customerRepo.save(newCustomer);
	}

	public Customer fetchCustomerById(int Id) {
		Optional<Customer> customer= customerRepo.findById(Id);
		if(customer.isPresent()) {return customer.get();}
		else {return null;}
	}


	public List<Customer> fetchAllCustomer() {
		return customerRepo.findAll();
	}

	public Customer deleteCustomer(int customerId) {
		Customer customer = fetchCustomerById(customerId);
		customerRepo.delete(customer);
		return customer;
	}
//-----------------------------------[FoodOrder OtM]------------------------------------------------

	public Customer addExistingFoodOrderToExistingCustomer(int customerId, int foodOrderId) {
		Customer customer = fetchCustomerById(customerId);
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		List<FoodOrder> foodOrders = customer.getFoodOrders();
		foodOrders.add(foodOrder);
		customer.setFoodOrders(foodOrders);
		return saveCustomer(customer);
	}

	public Customer addNewFoodOrderToExistingCustomer(int customerId, FoodOrder newfoodOrder) {
		Customer customer = fetchCustomerById(customerId);
		List<FoodOrder> foodOrders = customer.getFoodOrders();
		foodOrders.add(newfoodOrder);
		customer.setFoodOrders(foodOrders);
		return saveCustomer(customer);
	}

	

}
