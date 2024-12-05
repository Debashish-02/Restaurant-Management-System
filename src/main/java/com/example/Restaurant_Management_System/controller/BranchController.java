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

import com.example.Restaurant_Management_System.dto.Address;
import com.example.Restaurant_Management_System.dto.Branch;
import com.example.Restaurant_Management_System.dto.Customer;
import com.example.Restaurant_Management_System.dto.Employee;
import com.example.Restaurant_Management_System.dto.Manager;
import com.example.Restaurant_Management_System.dto.Menu;
import com.example.Restaurant_Management_System.service.BranchService;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@PutMapping("/updateBranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int oldId,
			@RequestBody Branch newBranch) {
		return branchService.updateBranch(oldId, newBranch);
	}

	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int Id) {
		return branchService.fetchBranchById(Id);
	}

	@GetMapping("/fetchAllBranch")
	public ResponseEntity<ResponseStructureList<Branch>> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}

	@DeleteMapping("/deleteBranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int branchId) {
		return branchService.deleteBranch(branchId);
	}
//-----------------------------[Manager]----------------------------------------

	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(@RequestParam int branchId,
			@RequestParam int managerId) {
		return branchService.addExistingManagerToExistingBranch(branchId, managerId);
	}

	@PutMapping("/addNewManagerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewManagerToExistingBranch(@RequestParam int branchId,
			@RequestBody Manager newmanager) {
		return branchService.addNewManagerToExistingBranch(branchId, newmanager);
	}

//-----------------------------[Menu]----------------------------------------

	@PutMapping("/addExistingMenuToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingMenuToExistingBranch(@RequestParam int branchId,
			@RequestParam int menuId) {
		return branchService.addExistingMenuToExistingBranch(branchId, menuId);
	}

	@PutMapping("/addNewMenuToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewMenuToExistingBranch(@RequestParam int branchId,
			@RequestBody Menu newmenu) {
		return branchService.addNewMenuToExistingBranch(branchId, newmenu);
	}

//-----------------------------[Address]----------------------------------------
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(@RequestParam int branchId,
			@RequestParam int addressId) {
		return branchService.addExistingAddressToExistingBranch(branchId, addressId);
	}

	@PutMapping("/addNewAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(@RequestParam int branchId,
			@RequestBody Address newaddress) {
		return branchService.addNewAddressToExistingBranch(branchId, newaddress);
	}
//-----------------------------[Employee OtM]----------------------------------------

	@PutMapping("/addExistingEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(@RequestParam int branchId,
			@RequestParam int employeeId) {
		return branchService.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}

	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(@RequestParam int branchId,
			@RequestBody Employee newemployee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, newemployee);
	}

	@PutMapping("/addAllExistingEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructureList<Branch>> addAllExistingEmployeeToExistingBranch(int branchId) {

		return branchService.addAllExistingEmployeeToExistingBranch(branchId);

	}

//-----------------------------[Customer OtM]----------------------------------------

	@PutMapping("/addExistingCustomerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(@RequestParam int branchId,
			@RequestParam int customerId) {
		return branchService.addExistingCustomerToExistingBranch(branchId, customerId);
	}

	@PutMapping("/addNewCustomerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(@RequestParam int branchId,
			@RequestBody Customer newcustomer) {
		return branchService.addNewCustomerToExistingBranch(branchId, newcustomer);
	}

	@PutMapping("/addAllExistingCustomerToExistingBranch")
	public ResponseEntity<ResponseStructureList<Branch>> addAllExistingCustomerToExistingBranch(int branchId) {

		return branchService.addAllExistingCustomerToExistingBranch(branchId);

	}

}
