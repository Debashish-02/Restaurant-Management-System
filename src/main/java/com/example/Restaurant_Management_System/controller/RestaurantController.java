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

import com.example.Restaurant_Management_System.dto.Branch;
import com.example.Restaurant_Management_System.dto.Restaurant;
import com.example.Restaurant_Management_System.service.RestaurantService;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@RestController
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@PostMapping("/saveRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> saveRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.saveRestaurant(restaurant);
	}

	@PutMapping("/updateRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurant(@RequestParam int oldId, @RequestBody Restaurant newRestaurant) {
		return restaurantService.updateRestaurant(oldId, newRestaurant);
	}

	@GetMapping("/fetchRestaurantById")
	public ResponseEntity<ResponseStructure<Restaurant>> fetchRestaurantById(@RequestParam int Id) {
		return restaurantService.fetchRestaurantById(Id);
	}

	@GetMapping("/fetchAllRestaurant")
	public ResponseEntity<ResponseStructureList<Restaurant>> fetchAllRestaurant() {
		return restaurantService.fetchAllRestaurant();
	}

	@DeleteMapping("/deleteRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> deleteRestaurant(@RequestParam int restaurantId) {
		return restaurantService.deleteRestaurant(restaurantId);
	}
//	--------------------------------------------------[Branch OtM]-----------------------------------------------
	@PutMapping("/addExistingBranchToExistingRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> addExistingBranchToExistingRestaurant(@RequestParam int restaurantId,@RequestParam int branchId) {
		return restaurantService.addExistingBranchToExistingRestaurant(restaurantId, branchId);
	}
 
  @PutMapping("/addNewBranchToExistingRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> addNewBranchToExistingRestaurant(@RequestParam int restaurantId,@RequestBody Branch newbranch) {
		return restaurantService.addNewBranchToExistingRestaurant(restaurantId, newbranch);
	}

  @PutMapping("/addAllExistingBranchToExistingRestaurant")
	public ResponseEntity<ResponseStructureList<Restaurant>> addAllExistingBranchToExistingRestaurant(int restaurantId) {
		
		return restaurantService.addAllExistingBranchToExistingRestaurant(restaurantId);
	
  }
}
