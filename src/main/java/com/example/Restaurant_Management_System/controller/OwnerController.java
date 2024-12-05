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

import com.example.Restaurant_Management_System.dto.Owner;
import com.example.Restaurant_Management_System.dto.Restaurant;
import com.example.Restaurant_Management_System.service.OwnerService;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;

	@PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}

	@PutMapping("/updateOwner")
	public ResponseEntity<ResponseStructure<Owner>> updateOwner(@RequestParam int oldId, @RequestBody Owner newOwner) {
		return ownerService.updateOwner(oldId, newOwner);
	}

	@GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int Id) {
		return ownerService.fetchOwnerById(Id);
	}

	@GetMapping("/fetchAllOwner")
	public ResponseEntity<ResponseStructureList<Owner>> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}

	@DeleteMapping("/deleteOwner")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwner(@RequestParam int ownerId) {
		return ownerService.deleteOwner(ownerId);
	}
//----------------------------------------------[Restaurant OtO]---------------------------------------------	
	
   @PutMapping("/addExistingRestaurantToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addExistingRestaurantToExistingOwner(@RequestParam int ownerId,@RequestParam int restaurantId) {
		return ownerService.addExistingRestaurantToExistingOwner(ownerId, restaurantId);
	}
   
   @PutMapping("/addNewRestaurantToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addNewRestaurantToExistingOwner(@RequestParam int ownerId,@RequestBody Restaurant newrestaurant) {
		return ownerService.addNewRestaurantToExistingOwner(ownerId, newrestaurant);
	}

}
