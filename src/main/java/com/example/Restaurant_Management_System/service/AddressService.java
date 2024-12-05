package com.example.Restaurant_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Restaurant_Management_System.dao.AddressDao;
import com.example.Restaurant_Management_System.dto.Address;
import com.example.Restaurant_Management_System.exception.AddressIdNotFound;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;
	@Autowired
	ResponseStructure<Address> responseStructure;
	@Autowired
	ResponseStructureList<Address> responseStructureList;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setMessage("Successfully Address Inserted into the DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int oldId, Address newAddress) {
		Address address = addressDao.fetchAddressById(oldId);
		if (address != null) {
			responseStructure.setMessage("Successfully Address Updated in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int Id) {
		Address address = addressDao.fetchAddressById(Id);
		if (address != null) {
			responseStructure.setMessage("Successfully Address Fetched from the DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AddressIdNotFound();
		}
	}
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setMessage("Successfully Address Deleted from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}



	public ResponseEntity<ResponseStructureList<Address>> fetchAllAddress() {
		responseStructureList.setMessage("Successfully Found All Address from the DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		List<Address> list = addressDao.fetchAllAddress();
		responseStructureList.setData(list);
		return new ResponseEntity<ResponseStructureList<Address>>(responseStructureList, HttpStatus.FOUND);
	}

}
