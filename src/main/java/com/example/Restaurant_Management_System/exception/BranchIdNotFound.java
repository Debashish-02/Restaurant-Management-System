package com.example.Restaurant_Management_System.exception;

public class BranchIdNotFound extends RuntimeException{
	private String message="Branch Id Not Found in the DataBase";
	public String getMessage() {
		return message;
	}
	
}

