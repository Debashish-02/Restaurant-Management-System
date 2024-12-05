package com.example.Restaurant_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Restaurant_Management_System.dao.OwnerDao;
import com.example.Restaurant_Management_System.dao.RestaurantDao;
import com.example.Restaurant_Management_System.dto.Owner;
import com.example.Restaurant_Management_System.dto.Restaurant;
import com.example.Restaurant_Management_System.exception.OwnerIdNotFound;
import com.example.Restaurant_Management_System.exception.RestaurantIdNotFound;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@Service
public class OwnerService {
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	RestaurantDao restaurantDao;
	@Autowired
	ResponseStructure<Owner> responseStructure;
	@Autowired
	ResponseStructureList<Owner> responseStructureList;

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		responseStructure.setMessage("Successfully Owner Inserted into the DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> updateOwner(int oldId, Owner newOwner) {
		Owner owner = ownerDao.fetchOwnerById(oldId);
		if (owner != null) {
			responseStructure.setMessage("Successfully Owner Updated in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(owner);
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int Id) {
		Owner owner = ownerDao.fetchOwnerById(Id);
		if (owner != null) {
			responseStructure.setMessage("Successfully Owner Fetched from the DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(owner);
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwner(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("Successfully Owner Deleted from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(owner);
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Owner>> fetchAllOwner() {
		responseStructureList.setMessage("Successfully Found All Owner from the DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		List<Owner> list = ownerDao.fetchAllOwner();
		responseStructureList.setData(list);
		return new ResponseEntity<ResponseStructureList<Owner>>(responseStructureList, HttpStatus.FOUND);
	}

//	-----------------------------------------------------------------------------------------------------------------
	public ResponseEntity<ResponseStructure<Owner>> addExistingRestaurantToExistingOwner(int ownerId,
			int restaurantId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		Restaurant restaurant = restaurantDao.fetchRestaurantById(restaurantId);
		if (owner == null) {
			throw new OwnerIdNotFound();
		} else if (restaurant == null) {
			throw new RestaurantIdNotFound();
		} else {
			responseStructure.setMessage("Successfully Restaurant linked to Owner  in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.addExistingRestaurantToExistingOwner(ownerId, restaurantId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> addNewRestaurantToExistingOwner(int ownerId,
			Restaurant newrestaurant) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("Successfully New Restaurant Added to Owner  inthe DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.addNewRestaurantToExistingOwner(ownerId, newrestaurant));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

}
