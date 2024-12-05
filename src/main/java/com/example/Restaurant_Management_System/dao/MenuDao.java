package com.example.Restaurant_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Restaurant_Management_System.dto.Menu;
import com.example.Restaurant_Management_System.repo.MenuRepo;

@Repository
public class MenuDao {

	@Autowired
	MenuRepo menuRepo;
	
	public Menu saveMenu(Menu menu) {


		return menuRepo.save(menu);
	}
	
	public Menu updateMenu(int oldId ,Menu newMenu) {
		newMenu.setMenuId(oldId);
		return menuRepo.save(newMenu);
	}
	
	public Menu fetchMenuById(int Id) {
		Optional<Menu> menu= menuRepo.findById(Id);
		if(menu.isPresent()) {return menu.get();}
		else {return null;}
	}

	
	public List<Menu> fetchAllMenu() {
		return menuRepo.findAll();
	}
	
	public Menu deleteMenu(int menuId) {
		Menu menu= fetchMenuById(menuId);
		 menuRepo.delete(menu);
		 return menu;
	}

}
