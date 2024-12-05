package com.example.Restaurant_Management_System.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuId;
	private String menuType;
	private String menuTimimg;
	private String menuAvailability;
	private int noOfItems;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuTimimg() {
		return menuTimimg;
	}

	public void setMenuTimimg(String menuTimimg) {
		this.menuTimimg = menuTimimg;
	}

	public String getMenuAvailability() {
		return menuAvailability;
	}

	public void setMenuAvailability(String menuAvailability) {
		this.menuAvailability = menuAvailability;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

}
