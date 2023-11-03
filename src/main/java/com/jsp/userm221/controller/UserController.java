package com.jsp.userm221.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.userm221.dao.UserDao;
import com.jsp.userm221.dto.User;
import com.jsp.userm221.service.UserService;
import com.jsp.userm221.util.ResponseStructure;

@RestController
public class UserController {
	
    @Autowired
    private  UserService service;

	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
	return	service.saveUser(user);
	}
	
	
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<User>> findUserById(@RequestParam int id) {
		return service.findUserById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PutMapping("/update")
	public ResponseStructure<User> updateUserById(@RequestParam int id,@RequestBody User user) {
		return service.updateUser(id,user);
	}
	
	@DeleteMapping("/delete")
	public ResponseStructure<User> deleteUserById(@RequestParam int id) {
		return service.deleteUserById(id);
	}
	
	@GetMapping("/findall")
	public ResponseStructure<List<User>> findAllUse(){
		return service.findAllUser();
	}
	
}
