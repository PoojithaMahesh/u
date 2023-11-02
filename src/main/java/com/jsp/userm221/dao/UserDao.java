package com.jsp.userm221.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userm221.dto.User;
import com.jsp.userm221.repository.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User findUserById(int id) {
		Optional<User> optional=repo.findById(id);
		
		if(optional.isPresent()) {
			User user=optional.get();
			return user;
		}else {
			return null;
		}
	}

	public User updateUser(int id, User user) {
	Optional<User> optional=repo.findById(id);
	if(optional.isPresent()) {
//		user is present inside this optional
		user.setId(id);
		return repo.save(user);	
	}else {
		return null;
	}
	
	
	}

	public User deleteUserById(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
			User user=optional.get();
			repo.delete(user);
//			repo.deleteById(id);
			return user;
		}else {
			return null;
		}
	}

	public List<User> findAllUser() {
		return repo.findAll();
	}

}
