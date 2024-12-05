package com.example.Restaurant_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Restaurant_Management_System.dto.Address;
import com.example.Restaurant_Management_System.dto.Branch;
import com.example.Restaurant_Management_System.dto.Customer;
import com.example.Restaurant_Management_System.dto.Employee;
import com.example.Restaurant_Management_System.dto.Manager;
import com.example.Restaurant_Management_System.dto.Menu;
import com.example.Restaurant_Management_System.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;

	@Autowired
	ManagerDao managerDao;

	@Autowired
	MenuDao menuDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	CustomerDao customerDao;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch updateBranch(int oldId, Branch newBranch) {
		newBranch.setBranchId(oldId);
		return branchRepo.save(newBranch);
	}

	public Branch fetchBranchById(int Id) {
		Optional<Branch> branch= branchRepo.findById(Id);
		if(branch.isPresent()) {return branch.get();}
		else {return null;}
	}


	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();
	}

	public Branch deleteBranch(int branchId) {
		Branch branch = fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}
//-----------------------------[Manager OtO]----------------------------------------	

	public Branch addExistingManagerToExistingBranch(int branchId, int managerId) {
		Branch branch = fetchBranchById(branchId);
		Manager manager = managerDao.fetchManagerById(managerId);
		branch.setManager(manager);
		return saveBranch(branch);
	}

	public Branch addNewManagerToExistingBranch(int branchId, Manager newmanager) {
		Branch branch = fetchBranchById(branchId);
		branch.setManager(newmanager);
		return saveBranch(branch);
	}

//-----------------------------[Menu OtO]----------------------------------------
	public Branch addExistingMenuToExistingBranch(int branchId, int menuId) {
		Branch branch = fetchBranchById(branchId);
		Menu menu = menuDao.fetchMenuById(menuId);
		branch.setMenu(menu);
		return saveBranch(branch);
	}

	public Branch addNewMenuToExistingBranch(int branchId, Menu newmenu) {
		Branch branch = fetchBranchById(branchId);
		branch.setMenu(newmenu);
		return saveBranch(branch);
	}

//-----------------------------[Address OtO]----------------------------------------	
	public Branch addExistingAddressToExistingBranch(int branchId, int addressId) {
		Branch branch = fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}

	public Branch addNewAddressToExistingBranch(int branchId, Address newaddress) {
		Branch branch = fetchBranchById(branchId);
		branch.setAddress(newaddress);
		return saveBranch(branch);
	}

//-----------------------------[Employee OtM]----------------------------------------	

	public Branch addExistingEmployeeToExistingBranch(int branchId, int employeeId) {
		Branch branch = fetchBranchById(branchId);
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		List<Employee> employees = branch.getEmployees();
		employees.add(employee);
		branch.setEmployees(employees);
		return saveBranch(branch);
	}

	public Branch addNewEmployeeToExistingBranch(int branchId, Employee newemployee) {
		Branch branch = fetchBranchById(branchId);
		List<Employee> employees = branch.getEmployees();
		employees.add(newemployee);
		branch.setEmployees(employees);
		return saveBranch(branch);
	}

	public Branch addAllExistingEmployeeToExistingBranch(int branchId) {
		Branch branch = fetchBranchById(branchId);
		branch.setEmployees(employeeDao.fetchAllEmployee());
		return saveBranch(branch);
	}
//-----------------------------[Customer OtM]----------------------------------------	

	public Branch addExistingCustomerToExistingBranch(int branchId, int customerId) {
		Branch branch = fetchBranchById(branchId);
		Customer customer = customerDao.fetchCustomerById(customerId);
		List<Customer> customers = branch.getCustomers();
		customers.add(customer);
		branch.setCustomers(customers);
		return saveBranch(branch);
	}

	public Branch addNewCustomerToExistingBranch(int branchId, Customer newcustomer) {
		Branch branch = fetchBranchById(branchId);
		List<Customer> customers = branch.getCustomers();
		customers.add(newcustomer);
		branch.setCustomers(customers);
		return saveBranch(branch);
	}

	public Branch addAllExistingCustomerToExistingBranch(int branchId) {
		Branch branch = fetchBranchById(branchId);
		branch.setCustomers(customerDao.fetchAllCustomer());
		return saveBranch(branch);
	}

}
