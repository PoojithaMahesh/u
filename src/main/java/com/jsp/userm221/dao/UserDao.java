package com.jsp.userm221.dao;

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

}
