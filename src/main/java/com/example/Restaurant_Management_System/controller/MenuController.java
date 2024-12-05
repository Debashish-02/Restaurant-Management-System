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

import com.example.Restaurant_Management_System.dto.Menu;
import com.example.Restaurant_Management_System.service.MenuService;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@RestController
public class MenuController {

	@Autowired
	MenuService menuService;

	@PostMapping("/saveMenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);
	}

	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int oldId, @RequestBody Menu newMenu) {
		return menuService.updateMenu(oldId, newMenu);
	}

	@GetMapping("/fetchMenuById")
	public ResponseEntity<ResponseStructure<Menu>> fetchMenuById(@RequestParam int Id) {
		return menuService.fetchMenuById(Id);
	}

	@GetMapping("/fetchAllMenu")
	public ResponseEntity<ResponseStructureList<Menu>> fetchAllMenu() {
		return menuService.fetchAllMenu();
	}

	@DeleteMapping("/deleteMenu")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int menuId) {
		return menuService.deleteMenu(menuId);
	}

}
