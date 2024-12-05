package com.example.Restaurant_Management_System.exception;

public class MenuIdNotFound extends RuntimeException{
	private String message="Menu Id Not Found in the DataBase";
	public String getMessage() {
		return message;
	}
	
}

