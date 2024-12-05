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

import com.example.Restaurant_Management_System.dto.Manager;
import com.example.Restaurant_Management_System.service.ManagerService;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@RestController
public class ManagerController {

	@Autowired
	ManagerService managerService;

	@PostMapping("/saveManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

	@PutMapping("/updateManager")
	public ResponseEntity<ResponseStructure<Manager>> updateManager(@RequestParam int oldId, @RequestBody Manager newManager) {
		return managerService.updateManager(oldId, newManager);
	}

	@GetMapping("/fetchManagerById")
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(@RequestParam int Id) {
		return managerService.fetchManagerById(Id);
	}

	@GetMapping("/fetchAllManager")
	public ResponseEntity<ResponseStructureList<Manager>> fetchAllManager() {
		return managerService.fetchAllManager();
	}

	@DeleteMapping("/deleteManager")
	public ResponseEntity<ResponseStructure<Manager>> deleteManager(@RequestParam int managerId) {
		return managerService.deleteManager(managerId);
	}

}
