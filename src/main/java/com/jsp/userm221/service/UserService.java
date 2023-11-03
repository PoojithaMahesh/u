package com.jsp.userm221.service;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.userm221.dao.UserDao;
import com.jsp.userm221.dto.User;
import com.jsp.userm221.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser=userDao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("User Data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}


	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		User dbUser=userDao.findUserById(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("User data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
			
			
		}else {
//			id is not present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Sorry id is not present");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
		}
		
	}


	public ResponseStructure<User> updateUser(int id, User user) {
	User dbUser=userDao.updateUser(id, user);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("User Data updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return structure;
			
		}else {
//			id is not present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Sorry id is not present");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return structure;
		}
		
		
		
	}


	public ResponseStructure<User> deleteUserById(int id) {
	User dbUser=userDao.findUserById(id);
	if(dbUser!=null) {
//		id is present
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("User Data deleted successfully");
		structure.setHttpStatus(HttpStatus.FOUND.value());
		structure.setData(dbUser);
		return structure;
		
	}else {
//		id is not present
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("Sorry id is not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(null);
		return structure;
	}
	}


	public ResponseStructure<List<User>> findAllUser() {
	    List<User> list=userDao.findAllUser();
		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
		structure.setMessage("User data fetched successfully");
		structure.setHttpStatus(HttpStatus.FOUND.value());
		structure.setData(list);
		return structure;
	}
	

}
