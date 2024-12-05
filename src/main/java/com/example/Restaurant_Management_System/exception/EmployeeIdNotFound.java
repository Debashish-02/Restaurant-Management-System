package com.example.Restaurant_Management_System.exception;

public class EmployeeIdNotFound extends RuntimeException{
	private String message="Employee Id Not Found in the DataBase";
	public String getMessage() {
		return message;
	}
	
}

