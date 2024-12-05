package com.example.Restaurant_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restaurant_Management_System.dto.Address;
import com.example.Restaurant_Management_System.service.AddressService;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@RestController
public class AddressController {


   @Autowired
	AddressService addressService;
   
   @PostMapping ("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
   
   @PutMapping ("/updateAddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int oldId,@RequestBody Address newAddress) {
		return addressService.updateAddress(oldId, newAddress);
	}
   
   @GetMapping ("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int Id) {
		return addressService.fetchAddressById(Id);
	}
   
   @GetMapping ("/fetchAllAddress")
	public ResponseEntity<ResponseStructureList<Address>> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}
   
   @DeleteMapping ("/deleteAddress")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int addressId) {
		return addressService.deleteAddress(addressId);
	}



}
