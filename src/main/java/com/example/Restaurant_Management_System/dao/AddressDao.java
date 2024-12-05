package com.example.Restaurant_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Restaurant_Management_System.dto.Address;
import com.example.Restaurant_Management_System.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public Address updateAddress(int oldId ,Address newAddress) {
		newAddress.setAddressId(oldId);
		return addressRepo.save(newAddress);
	}
	
	public Address fetchAddressById(int Id) {
		Optional<Address> address= addressRepo.findById(Id);
		if(address.isPresent()) {return address.get();}
		else {return null;}
	}

	
	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
	
	public Address deleteAddress(int addressId) {
		Address address= fetchAddressById(addressId);
		 addressRepo.delete(address);
		 return address;
	}

}
