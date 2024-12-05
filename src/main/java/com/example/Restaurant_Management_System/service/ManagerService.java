package com.example.Restaurant_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Restaurant_Management_System.dao.ManagerDao;
import com.example.Restaurant_Management_System.dto.Manager;
import com.example.Restaurant_Management_System.exception.ManagerIdNotFound;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;
	@Autowired
	ResponseStructure<Manager> responseStructure;
	@Autowired
	ResponseStructureList<Manager> responseStructureList;

	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		responseStructure.setMessage("Successfully Manager Inserted into the DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Manager>> updateManager(int oldId, Manager newManager) {
		Manager manager = managerDao.fetchManagerById(oldId);
		if (manager != null) {
			responseStructure.setMessage("Successfully Manager Updated in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(manager);
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(int Id) {
		Manager manager = managerDao.fetchManagerById(Id);
		if (manager != null) {
			responseStructure.setMessage("Successfully Manager Fetched from the DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(manager);
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> deleteManager(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if (manager != null) {
			responseStructure.setMessage("Successfully Manager Deleted from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(manager);
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Manager>> fetchAllManager() {
		responseStructureList.setMessage("Successfully Found All Manager from the DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		List<Manager> list = managerDao.fetchAllManager();
		responseStructureList.setData(list);
		return new ResponseEntity<ResponseStructureList<Manager>>(responseStructureList, HttpStatus.FOUND);
	}

}
