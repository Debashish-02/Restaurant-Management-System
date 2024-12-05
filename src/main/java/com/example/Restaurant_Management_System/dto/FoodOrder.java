package com.example.Restaurant_Management_System.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class FoodOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int foodOrderId;
		private String foodName;
		private double foodPrice;
		private int foodQuantity;
		private int foodDiscount;
		private double foodGST;
		public int getFoodOrderId() {
			return foodOrderId;
		}
		public void setFoodOrderId(int foodOrderId) {
			this.foodOrderId = foodOrderId;
		}
		public String getFoodName() {
			return foodName;
		}
		public void setFoodName(String foodName) {
			this.foodName = foodName;
		}
		public double getFoodPrice() {
			return foodPrice;
		}
		public void setFoodPrice(double foodPrice) {
			this.foodPrice = foodPrice;
		}
		public int getFoodQuantity() {
			return foodQuantity;
		}
		public void setFoodQuantity(int foodQuantity) {
			this.foodQuantity = foodQuantity;
		}
		public int getFoodDiscount() {
			return foodDiscount;
		}
		public void setFoodDiscount(int foodDiscount) {
			this.foodDiscount = foodDiscount;
		}
		public double getFoodGST() {
			return foodGST;
		}
		public void setFoodGST(double foodGST) {
			this.foodGST = foodGST;
		}
		
		
		
		
}
