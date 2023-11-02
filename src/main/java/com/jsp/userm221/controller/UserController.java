package com.jsp.userm221.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseStructure<User> saveUser(@RequestBody User user) {
	return	service.saveUser(user);
	}
	
	
	
	
//	@GetMapping("/find")
//	public User findUserById(@RequestParam int id) {
//		return userDao.findUserById(id);
//	}
//	
//	@PutMapping("/update")
//	public User updateUserById(@RequestParam int id,@RequestBody User user) {
//		return userDao.updateUser(id,user);
//	}
//	
//	@DeleteMapping("/delete")
//	public User deleteUserById(@RequestParam int id) {
//		return userDao.deleteUserById(id);
//	}
//	
//	@GetMapping("/findall")
//	public List<User> findAllUse(){
//		return userDao.findAllUser();
//	}
	
}
