package com.example.Restaurant_Management_System.exception;

public class AddressIdNotFound extends RuntimeException{
	private String message="Address Id Not Found in the DataBase";
	public String getMessage() {
		return message;
	}
	
}

