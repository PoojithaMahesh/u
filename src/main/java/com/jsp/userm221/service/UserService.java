package com.jsp.userm221.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.userm221.dao.UserDao;
import com.jsp.userm221.dto.User;
import com.jsp.userm221.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	
	public ResponseStructure<User> saveUser(User user) {
		User dbUser=userDao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("User Data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return structure;
	}
	

}
