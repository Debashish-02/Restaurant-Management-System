package com.example.Restaurant_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Restaurant_Management_System.dao.FoodOrderDao;
import com.example.Restaurant_Management_System.dto.FoodOrder;
import com.example.Restaurant_Management_System.exception.FoodOrderIdNotFound;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao foodOrderDao;
	@Autowired
	ResponseStructure<FoodOrder> responseStructure;
	@Autowired
	ResponseStructureList<FoodOrder> responseStructureList;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		responseStructure.setMessage("Successfully FoodOrder Inserted into the DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(foodOrderDao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(int oldId, FoodOrder newFoodOrder) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(oldId);
		if (foodOrder != null) {
			responseStructure.setMessage("Successfully FoodOrder Updated in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> fetchFoodOrderById(int Id) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(Id);
		if (foodOrder != null) {
			responseStructure.setMessage("Successfully FoodOrder Fetched from the DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new FoodOrderIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int foodOrderId) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		if (foodOrder != null) {
			responseStructure.setMessage("Successfully FoodOrder Deleted from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<FoodOrder>> fetchAllFoodOrder() {
		responseStructureList.setMessage("Successfully Found All FoodOrder from the DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		List<FoodOrder> list = foodOrderDao.fetchAllFoodOrder();
		responseStructureList.setData(list);
		return new ResponseEntity<ResponseStructureList<FoodOrder>>(responseStructureList, HttpStatus.FOUND);
	}

}







