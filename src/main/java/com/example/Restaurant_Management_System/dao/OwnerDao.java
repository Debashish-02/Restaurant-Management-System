package com.example.Restaurant_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Restaurant_Management_System.dto.Owner;
import com.example.Restaurant_Management_System.dto.Restaurant;
import com.example.Restaurant_Management_System.repo.OwnerRepo;


@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
     RestaurantDao restaurantDao;
	
	public Owner saveOwner(Owner owner) {

		return ownerRepo.save(owner);
	}

	public Owner updateOwner(int oldId, Owner newOwner) {
		newOwner.setOwnerId(oldId);
		return ownerRepo.save(newOwner);
	}

	public Owner fetchOwnerById(int Id) {
		Optional<Owner> owner= ownerRepo.findById(Id);
		if(owner.isPresent()) {return owner.get();}
		else {return null;}
	}

	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();
	}

	public Owner deleteOwner(int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}
	
	public Owner addExistingRestaurantToExistingOwner(int ownerId, int restaurantId) {
		Owner owner = fetchOwnerById(ownerId);
		Restaurant restaurant=  restaurantDao.fetchRestaurantById(restaurantId);
		owner.setRestaurant(restaurant);
		return saveOwner(owner);
	}
	
	public Owner addNewRestaurantToExistingOwner(int ownerId, Restaurant newrestaurant) {
		Owner owner = fetchOwnerById(ownerId);
		owner.setRestaurant(newrestaurant);
		return saveOwner(owner);
	}
}
