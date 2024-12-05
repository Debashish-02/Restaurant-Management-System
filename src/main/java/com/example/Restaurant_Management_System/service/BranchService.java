package com.example.Restaurant_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Restaurant_Management_System.dao.AddressDao;
import com.example.Restaurant_Management_System.dao.BranchDao;
import com.example.Restaurant_Management_System.dao.CustomerDao;
import com.example.Restaurant_Management_System.dao.EmployeeDao;
import com.example.Restaurant_Management_System.dao.ManagerDao;
import com.example.Restaurant_Management_System.dao.MenuDao;
import com.example.Restaurant_Management_System.dto.Address;
import com.example.Restaurant_Management_System.dto.Branch;
import com.example.Restaurant_Management_System.dto.Customer;
import com.example.Restaurant_Management_System.dto.Employee;
import com.example.Restaurant_Management_System.dto.Manager;
import com.example.Restaurant_Management_System.dto.Menu;
import com.example.Restaurant_Management_System.exception.AddressIdNotFound;
import com.example.Restaurant_Management_System.exception.BranchIdNotFound;
import com.example.Restaurant_Management_System.exception.CustomerIdNotFound;
import com.example.Restaurant_Management_System.exception.EmployeeIdNotFound;
import com.example.Restaurant_Management_System.exception.ManagerIdNotFound;
import com.example.Restaurant_Management_System.exception.MenuIdNotFound;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;
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

	@Autowired
	ResponseStructure<Branch> responseStructure;
	@Autowired
	ResponseStructureList<Branch> responseStructureList;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setMessage("Successfully Branch Inserted into the DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int oldId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldId);
		if (branch != null) {
			responseStructure.setMessage("Successfully Branch Updated in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int Id) {
		Branch branch = branchDao.fetchBranchById(Id);
		if (branch != null) {
			responseStructure.setMessage("Successfully Branch Fetched from the DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully Branch Deleted from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Branch>> fetchAllBranch() {
		responseStructureList.setMessage("Successfully Found All Branch from the DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		List<Branch> list = branchDao.fetchAllBranch();
		responseStructureList.setData(list);
		return new ResponseEntity<ResponseStructureList<Branch>>(responseStructureList, HttpStatus.FOUND);
	}

//-----------------------------[Manager]----------------------------------------

//	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(int branchId, int managerId) {
//		responseStructure.setMessage("Successfully Manager linked to Branch  in the DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(branchDao.addExistingManagerToExistingBranch(branchId, managerId));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
//	}
//
//	public ResponseEntity<ResponseStructure<Branch>> addNewManagerToExistingBranch(int branchId, Manager newmanager) {
//		responseStructure.setMessage("Successfully New Manager Added to Branch  in the DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(branchDao.addNewManagerToExistingBranch(branchId, newmanager));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
//	}
	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(int branchId, int managerId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Manager manager = managerDao.fetchManagerById(managerId);
		if (branch == null) {
			throw new BranchIdNotFound();
		} else if (manager == null) {
			throw new ManagerIdNotFound();
		} else {
			responseStructure.setMessage("Successfully Manager linked to Branch  in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingManagerToExistingBranch(branchId, managerId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewManagerToExistingBranch(int branchId, Manager newmanager) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully New Manager Added to Branch  inthe DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addNewManagerToExistingBranch(branchId, newmanager));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

//-----------------------------[Menu]----------------------------------------
//	public ResponseEntity<ResponseStructure<Branch>> addExistingMenuToExistingBranch(int branchId, int menuId) {
//		responseStructure.setMessage("Successfully Menu linked to Branch  in the DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(branchDao.addExistingMenuToExistingBranch(branchId, menuId));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
//	}
//
//	public ResponseEntity<ResponseStructure<Branch>> addNewMenuToExistingBranch(int branchId, Menu newmenu) {
//		responseStructure.setMessage("Successfully New Menu  Added to Branch  inthe DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(branchDao.addNewMenuToExistingBranch(branchId, newmenu));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
//	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingMenuToExistingBranch(int branchId, int menuId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Menu menu = menuDao.fetchMenuById(menuId);
		if (branch == null) {
			throw new BranchIdNotFound();
		} else if (menu == null) {
			throw new MenuIdNotFound();
		} else {
			responseStructure.setMessage("Successfully Menu linked to Branch  in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingMenuToExistingBranch(branchId, menuId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewMenuToExistingBranch(int branchId, Menu newmenu) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully New Menu Added to Branch  inthe DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addNewMenuToExistingBranch(branchId, newmenu));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

//-----------------------------[Address]----------------------------------------	
//	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int branchId, int addressId) {
//		responseStructure.setMessage("Successfully Address linked to Branch  in the DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(branchId, addressId));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
//	}
//
//	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int branchId, Address newaddress) {
//		responseStructure.setMessage("Successfully New Address Added to Branch  inthe DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(branchDao.addNewAddressToExistingBranch(branchId, newaddress));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
//	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int branchId, int addressId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		if (branch == null) {
			throw new BranchIdNotFound();
		} else if (address == null) {
			throw new AddressIdNotFound();
		} else {
			responseStructure.setMessage("Successfully Address linked to Branch  in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingAddressToExistingBranch(branchId, addressId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int branchId, Address newaddress) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully New Address Added to Branch  inthe DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addNewAddressToExistingBranch(branchId, newaddress));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

//-----------------------------[Employee OtM]----------------------------------------		
//	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(int branchId, int employeeId) {
//		responseStructure.setMessage("Successfully Employee linked to Branch  in the DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
//	}
//
//	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(int branchId,
//			Employee newemployee) {
//		responseStructure.setMessage("Successfully New Employee Added to Branch  inthe DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(branchId, newemployee));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
//	}
	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(int branchId, int employeeId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (branch == null) {
			throw new BranchIdNotFound();
		} else if (employee == null) {
			throw new EmployeeIdNotFound();
		} else {
			responseStructure.setMessage("Successfully Employee linked to Branch  in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(int branchId,
			Employee newemployee) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully New Employee Added to Branch  inthe DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(branchId, newemployee));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Branch>> addAllExistingEmployeeToExistingBranch(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully All Employee Added to the Branch  in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addAllExistingEmployeeToExistingBranch(branchId));
			return new ResponseEntity<ResponseStructureList<Branch>>(responseStructureList, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

//-----------------------------[Customer OtM]----------------------------------------	

//	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(int branchId, int customerId) {
//		responseStructure.setMessage("Successfully Customer linked to Branch  in the DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(branchDao.addExistingCustomerToExistingBranch(branchId, customerId));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
//	}
//
//	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(int branchId,
//			Customer newcustomer) {
//		responseStructure.setMessage("Successfully New Customer Added to Branch  inthe DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(branchDao.addNewCustomerToExistingBranch(branchId, newcustomer));
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
//	}
	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(int branchId, int customerId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (branch == null) {
			throw new BranchIdNotFound();
		} else if (customer == null) {
			throw new CustomerIdNotFound();
		} else {
			responseStructure.setMessage("Successfully Customer linked to Branch  in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingCustomerToExistingBranch(branchId, customerId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(int branchId,
			Customer newcustomer) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully New Customer Added to Branch  inthe DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addNewCustomerToExistingBranch(branchId, newcustomer));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Branch>> addAllExistingCustomerToExistingBranch(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully All Customers Added to the Branch  in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addAllExistingCustomerToExistingBranch(branchId));
			return new ResponseEntity<ResponseStructureList<Branch>>(responseStructureList, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

}
