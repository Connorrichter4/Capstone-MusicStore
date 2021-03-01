package com.hcl.capstone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // might have to change
	private long id;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private String state;
	
	private String zipcode;
	
	private String credit_card;
	
	private String role;
	
	
}
