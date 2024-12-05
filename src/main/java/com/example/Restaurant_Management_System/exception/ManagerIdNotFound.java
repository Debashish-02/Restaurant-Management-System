package com.example.Restaurant_Management_System.exception;

public class ManagerIdNotFound extends RuntimeException{
	private String message="Manager Id Not Found in the DataBase";
	public String getMessage() {
		return message;
	}
	
}

