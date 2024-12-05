package com.example.Restaurant_Management_System.exception;

public class CustomerIdNotFound extends RuntimeException{
	private String message="Customer Id Not Found in the DataBase";
	public String getMessage() {
		return message;
	}
	
}

