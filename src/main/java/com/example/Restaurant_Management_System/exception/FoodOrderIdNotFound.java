package com.example.Restaurant_Management_System.exception;

public class FoodOrderIdNotFound extends RuntimeException{
	private String message="FoodOrder Id Not Found in the DataBase";
	public String getMessage() {
		return message;
	}
	
}


