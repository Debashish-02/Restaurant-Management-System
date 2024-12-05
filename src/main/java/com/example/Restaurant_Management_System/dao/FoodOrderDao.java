package com.example.Restaurant_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Restaurant_Management_System.dto.FoodOrder;
import com.example.Restaurant_Management_System.repo.FoodOrderRepo;
@Repository
public class FoodOrderDao {

	@Autowired
	FoodOrderRepo foodOrderRepo;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepo.save(foodOrder);
	}
	
	public FoodOrder updateFoodOrder(int oldId ,FoodOrder newFoodOrder) {
		newFoodOrder.setFoodOrderId(oldId);
		return foodOrderRepo.save(newFoodOrder);
	}
	
	public FoodOrder fetchFoodOrderById(int Id) {
		Optional<FoodOrder> foodOrder= foodOrderRepo.findById(Id);
		if(foodOrder.isPresent()) {return foodOrder.get();}
		else {return null;}
	}

	
	public List<FoodOrder> fetchAllFoodOrder() {
		return foodOrderRepo.findAll();
	}
	
	public FoodOrder deleteFoodOrder(int foodOrderId) {
		FoodOrder foodOrder= fetchFoodOrderById(foodOrderId);
		 foodOrderRepo.delete(foodOrder);
		 return foodOrder;
	}

}
