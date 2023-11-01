package com.jsp.userm221.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
     @Id
	private int id;
	private String name;
	private String address;
	private long phone;
	
	
	
	
}

