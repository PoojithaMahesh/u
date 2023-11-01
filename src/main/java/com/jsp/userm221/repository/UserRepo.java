package com.jsp.userm221.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.userm221.dto.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
