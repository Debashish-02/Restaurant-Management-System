package com.example.Restaurant_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Restaurant_Management_System.dao.MenuDao;
import com.example.Restaurant_Management_System.dto.Menu;
import com.example.Restaurant_Management_System.exception.MenuIdNotFound;
import com.example.Restaurant_Management_System.util.ResponseStructure;
import com.example.Restaurant_Management_System.util.ResponseStructureList;

@Service
public class MenuService {
	@Autowired
	MenuDao menuDao;
	@Autowired
	ResponseStructure<Menu> responseStructure;
	@Autowired
	ResponseStructureList<Menu> responseStructureList;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		responseStructure.setMessage("Successfully Menu Inserted into the DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(menuDao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(int oldId, Menu newMenu) {
		Menu menu = menuDao.fetchMenuById(oldId);
		if (menu != null) {
			responseStructure.setMessage("Successfully Menu Updated in the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MenuIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> fetchMenuById(int Id) {
		Menu menu = menuDao.fetchMenuById(Id);
		if (menu != null) {
			responseStructure.setMessage("Successfully Menu Fetched from the DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new MenuIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int menuId) {
		Menu menu = menuDao.fetchMenuById(menuId);
		if (menu != null) {
			responseStructure.setMessage("Successfully Menu Deleted from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MenuIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Menu>> fetchAllMenu() {
		responseStructureList.setMessage("Successfully Found All Menu from the DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		List<Menu> list = menuDao.fetchAllMenu();
		responseStructureList.setData(list);
		return new ResponseEntity<ResponseStructureList<Menu>>(responseStructureList, HttpStatus.FOUND);
	}

}
