package com.example.Restaurant_Management_System.exception;

public class RestaurantIdNotFound extends RuntimeException{
	private String message="Restaurant Id Not Found in the DataBase";
	public String getMessage() {
		return message;
	}
	
}

