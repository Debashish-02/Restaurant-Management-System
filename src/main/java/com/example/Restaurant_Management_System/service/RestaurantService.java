package com.example.Restaurant_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Restaurant_Management_System.dao.BranchDao;
import com.example.Restaurant_Management_System.dao.RestaurantDao;
import com.example.Restaurant_Management_System.dto.Branch;
import com.example.Restaurant_Management_System.dto.Restaurant;
import com.example.Restaurant_Management_System.exception.BranchIdNotFound;
import com.example.Restaurant_Management_System.exception.RestaurantIdNotFound;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@Service
public class RestaurantService {
	@Autowired
	RestaurantDao restaurantDao;
	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponseStructure<Restaurant> responseStructure;
	@Autowired
	ResponseStructureList<Restaurant> responseStructureList;

	public ResponseEntity<ResponseStructure<Restaurant>> saveRestaurant(Restaurant restaurant) {
		responseStructure.setMessage("Successfully Restaurant Inserted into the DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(restaurantDao.saveRestaurant(restaurant));
		return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurant(int oldId, Restaurant newRestaurant) {
		Restaurant restaurant = restaurantDao.fetchRestaurantById(oldId);
		if (restaurant != null) {
			responseStructure.setMessage("Successfully Restaurant Updated in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(restaurant);
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		} else {
			throw new RestaurantIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Restaurant>> fetchRestaurantById(int Id) {
		Restaurant restaurant = restaurantDao.fetchRestaurantById(Id);
		if (restaurant != null) {
			responseStructure.setMessage("Successfully Restaurant Fetched from the DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(restaurant);
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new RestaurantIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Restaurant>> deleteRestaurant(int restaurantId) {
		Restaurant restaurant = restaurantDao.fetchRestaurantById(restaurantId);
		if (restaurant != null) {
			responseStructure.setMessage("Successfully Restaurant Deleted from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(restaurant);
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		} else {
			throw new RestaurantIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Restaurant>> fetchAllRestaurant() {
		responseStructureList.setMessage("Successfully Found All Restaurant from the DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		List<Restaurant> list = restaurantDao.fetchAllRestaurant();
		responseStructureList.setData(list);
		return new ResponseEntity<ResponseStructureList<Restaurant>>(responseStructureList, HttpStatus.FOUND);
	}

//	---------------------------------------[Branch OtM]---------------------------------------------------

//	public ResponseEntity<ResponseStructure<Restaurant>> addExistingBranchToExistingRestaurant(int restaurantId,
//			int branchId) {
//		responseStructure.setMessage("Successfully Branch linked to Restaurant  in the DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(restaurantDao.addExistingBranchToExistingRestaurant(restaurantId, branchId));
//		return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
//	}
//
//	public ResponseEntity<ResponseStructure<Restaurant>> addNewBranchToExistingRestaurant(int restaurantId,
//			Branch newbranch) {
//		responseStructure.setMessage("Successfully New Branch Added to Restaurant  inthe DB");
//		responseStructure.setStatusCode(HttpStatus.OK.value());
//		responseStructure.setData(restaurantDao.addNewBranchToExistingRestaurant(restaurantId, newbranch));
//		return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
//	}

	public ResponseEntity<ResponseStructure<Restaurant>> addExistingBranchToExistingRestaurant(int restaurantId,
			int branchId) {
		Restaurant restaurant = restaurantDao.fetchRestaurantById(restaurantId);
		Branch branch = branchDao.fetchBranchById(branchId);
		if (restaurant == null) {
			throw new RestaurantIdNotFound();
		} else if (branch == null) {
			throw new BranchIdNotFound();
		} else {
			responseStructure.setMessage("Successfully Branch linked to Restaurant  in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(restaurantDao.addExistingBranchToExistingRestaurant(restaurantId, branchId));
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		}
	}
	public ResponseEntity<ResponseStructure<Restaurant>> addNewBranchToExistingRestaurant(int restaurantId,
			Branch newbranch) {
		Restaurant restaurant = restaurantDao.fetchRestaurantById(restaurantId);
		if (restaurant != null) {
			responseStructure.setMessage("Successfully New Branch Added to Restaurant  inthe DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(restaurantDao.addNewBranchToExistingRestaurant(restaurantId, newbranch));
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		} else {
			throw new RestaurantIdNotFound();
		}
	}


	public ResponseEntity<ResponseStructureList<Restaurant>> addAllExistingBranchToExistingRestaurant(
			int restaurantId) {
		responseStructure.setMessage("Successfully New Branch Added to Restaurant  inthe DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(restaurantDao.addAllExistingBranchToExistingRestaurant(restaurantId));
		return new ResponseEntity<ResponseStructureList<Restaurant>>(responseStructureList, HttpStatus.OK);
	}

}
