package com.example.Restaurant_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Restaurant_Management_System.dto.Manager;
import com.example.Restaurant_Management_System.repo.ManagerRepo;
@Repository
public class ManagerDao {

	@Autowired
	ManagerRepo managerRepo;
	
	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}
	
	public Manager updateManager(int oldId ,Manager newManager) {
		newManager.setManagerId(oldId);
		return managerRepo.save(newManager);
	}
	
	public Manager fetchManagerById(int Id) {
		Optional<Manager> manager= managerRepo.findById(Id);
		if(manager.isPresent()) {return manager.get();}
		else {return null;}
	}

	
	public List<Manager> fetchAllManager() {
		return managerRepo.findAll();
	}
	
	public Manager deleteManager(int managerId) {
		Manager manager= fetchManagerById(managerId);
		 managerRepo.delete(manager);
		 return manager;
	}

}
