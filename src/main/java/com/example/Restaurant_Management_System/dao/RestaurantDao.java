package com.example.Restaurant_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Restaurant_Management_System.dto.Branch;
import com.example.Restaurant_Management_System.dto.Restaurant;
import com.example.Restaurant_Management_System.repo.RestaurantRepo;

@Repository
public class RestaurantDao {

	@Autowired
	RestaurantRepo restaurantRepo;
	@Autowired
	BranchDao branchDao;
	

	public Restaurant saveRestaurant(Restaurant restaurant) {

		return restaurantRepo.save(restaurant);
	}

	public Restaurant updateRestaurant(int oldId, Restaurant newRestaurant) {
		newRestaurant.setRestaurantId(oldId);
		return restaurantRepo.save(newRestaurant);
	}

	public Restaurant fetchRestaurantById(int Id) {
		Optional<Restaurant> restaurant= restaurantRepo.findById(Id);
		if(restaurant.isPresent()) {return restaurant.get();}
		else {return null;}
	}


	public List<Restaurant> fetchAllRestaurant() {
		return restaurantRepo.findAll();
	}

	public Restaurant deleteRestaurant(int restaurantId) {
		Restaurant restaurant = fetchRestaurantById(restaurantId);
		restaurantRepo.delete(restaurant);
		return restaurant;
	}

//	-----------------------[Branch]-----------------------------------
	
	public Restaurant addExistingBranchToExistingRestaurant(int restaurantId, int branchId) {
		Restaurant restaurant = fetchRestaurantById(restaurantId);
		Branch branch=  branchDao.fetchBranchById(branchId);
		List<Branch> branchs = restaurant.getBranchs();		
		branchs.add(branch);
		restaurant.setBranchs(branchs);	
		return saveRestaurant(restaurant);
	}
	public Restaurant addAllExistingBranchToExistingRestaurant(int restaurantId) {
		Restaurant restaurant = fetchRestaurantById(restaurantId);
		restaurant.setBranchs(branchDao.fetchAllBranch());	
		return saveRestaurant(restaurant);
	}
	
	public Restaurant addNewBranchToExistingRestaurant(int restaurantId, Branch newbranch) {
		Restaurant restaurant = fetchRestaurantById(restaurantId);
		List<Branch> branchs = restaurant.getBranchs();		
		branchs.add(newbranch);
		restaurant.setBranchs(branchs);
		return saveRestaurant(restaurant);
	}


}
