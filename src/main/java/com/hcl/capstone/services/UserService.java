package com.hcl.capstone.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder; (keep for security)
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.User;
import com.hcl.capstone.repositories.UserRepository;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Autowired (saving for security)
//	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	public User createUser(User user) {
		
//		user.setPassword(passwordEncoder.encode(user.getPassword())); (keep for security)
		user.toString();
		
//		checking if the user already exists in the database
		if(getUserByEmail(user.getEmail()) != null) {
			return null;
		}
		
		return userRepository.save(user);
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
}
