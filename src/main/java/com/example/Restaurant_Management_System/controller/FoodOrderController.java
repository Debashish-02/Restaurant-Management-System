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

import com.example.Restaurant_Management_System.dto.FoodOrder;
import com.example.Restaurant_Management_System.service.FoodOrderService;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@RestController
public class FoodOrderController {

	@Autowired
	FoodOrderService foodOrderService;

	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}

	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestParam int oldId,
			@RequestBody FoodOrder newFoodOrder) {
		return foodOrderService.updateFoodOrder(oldId, newFoodOrder);
	}

	@GetMapping("/fetchFoodOrderById")
	public ResponseEntity<ResponseStructure<FoodOrder>> fetchFoodOrderById(@RequestParam int Id) {
		return foodOrderService.fetchFoodOrderById(Id);
	}

	@GetMapping("/fetchAllFoodOrder")
	public ResponseEntity<ResponseStructureList<FoodOrder>> fetchAllFoodOrder() {
		return foodOrderService.fetchAllFoodOrder();
	}

	@DeleteMapping("/deleteFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int foodOrderId) {
		return foodOrderService.deleteFoodOrder(foodOrderId);
	}

}
