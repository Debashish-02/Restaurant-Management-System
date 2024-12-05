package com.example.Restaurant_Management_System.exception;

public class OwnerIdNotFound extends RuntimeException{

	private String message="Owner Id Not Found in the DataBase";

	public String getMessage() {
		return message;
	}
	
}
