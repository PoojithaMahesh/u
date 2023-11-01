package com.jsp.userm221.controller;

import org.apache.catalina.startup.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.userm221.dao.UserDao;
import com.jsp.userm221.dto.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;

	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
	return	userDao.saveUser(user);
	}
	
	@GetMapping("/find")
	public User findUserById(@RequestParam int id) {
		return userDao.findUserById(id);
	}
	
	
}
