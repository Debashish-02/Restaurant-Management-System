package com.example.Restaurant_Management_System.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int branchId;
		private String branchName;
		private String branchEmail;
		private double branchRevenue;
		private long branchPhone;
		

		@OneToOne(cascade =  CascadeType.ALL)
		private Address address;
		@OneToOne(cascade =  CascadeType.ALL)
		private Manager manager;
		@OneToOne(cascade =  CascadeType.ALL)
		private Menu menu;
		
		@OneToMany(cascade = CascadeType.ALL)
		private List<Employee> employees;
		@OneToMany(cascade = CascadeType.ALL)
		private List<Customer> customers;
		
		
		
		public List<Customer> getCustomers() {
			return customers;
		}
		public void setCustomers(List<Customer> customers) {
			this.customers = customers;
		}
		public List<Employee> getEmployees() {
			return employees;
		}
		public void setEmployees(List<Employee> employee) {
			this.employees = employee;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public Manager getManager() {
			return manager;
		}
		public void setManager(Manager manager) {
			this.manager = manager;
		}
		public Menu getMenu() {
			return menu;
		}
		public void setMenu(Menu menu) {
			this.menu = menu;
		}
		public int getBranchId() {
			return branchId;
		}
		public void setBranchId(int branchId) {
			this.branchId = branchId;
		}
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public String getBranchEmail() {
			return branchEmail;
		}
		public void setBranchEmail(String branchEmail) {
			this.branchEmail = branchEmail;
		}
		public double getBranchRevenue() {
			return branchRevenue;
		}
		public void setBranchRevenue(double branchRevenue) {
			this.branchRevenue = branchRevenue;
		}
		public long getBranchPhone() {
			return branchPhone;
		}
		public void setBranchPhone(long branchPhone) {
			this.branchPhone = branchPhone;
		}
		
		
}
