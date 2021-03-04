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

	public Iterable<User> getAll() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	public User createUser(User user) {

//		user.setPassword(passwordEncoder.encode(user.getPassword())); (keep for security)
		user.toString();

//		checking if the user already exists in the database
		if (getUserByEmail(user.getEmail()) != null) {
			return null;
		}
		
		// set the user role to user by default
		user.setRole("USER");

		return userRepository.save(user);
	}

	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	public User updateUser(User user) {
		User oldUser = userRepository.findById(user.getId()).get();
		
		// check if the updated email matches another users email
		if(!oldUser.getEmail().equals(user.getEmail())) {
			logger.info("email updated");
			
		}
		
		oldUser.setEmail(user.getEmail());
		oldUser.setPassword(user.getPassword());
		oldUser.setAddress(user.getAddress());
		oldUser.setState(user.getState());
		oldUser.setZipcode(user.getZipcode());
		oldUser.setCredit_card(user.getCredit_card());
		oldUser.setRole(user.getRole());
		return userRepository.save(oldUser);
	}

	public void deleteUser(Long id) {
		User user = userRepository.findById(id).get();
		logger.info(user.toString());
		userRepository.delete(user);
	}

}
