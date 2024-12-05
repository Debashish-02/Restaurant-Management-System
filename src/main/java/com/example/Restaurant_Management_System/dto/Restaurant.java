package com.example.Restaurant_Management_System.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;
	private String restaurantName;
	private String restaurantEmail;
	private String restaurantGSTIN;
	private long restaurantPhone;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branchs;

	public List<Branch> getBranchs() {
		return branchs;
	}

	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	public String getRestaurantGSTIN() {
		return restaurantGSTIN;
	}

	public void setRestaurantGSTIN(String restaurantGSTIN) {
		this.restaurantGSTIN = restaurantGSTIN;
	}

	public long getRestaurantPhone() {
		return restaurantPhone;
	}

	public void setRestaurantPhone(long restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}

}
