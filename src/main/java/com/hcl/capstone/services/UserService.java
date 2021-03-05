package com.hcl.capstone.services;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; //(keep for security)
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.Role;
import com.hcl.capstone.entities.User;
import com.hcl.capstone.repositories.RoleRepository;
import com.hcl.capstone.repositories.UserRepository;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired // (saving for security)
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	public Iterable<User> getAll() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	public User createUser(User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));// (keep for security)
		logger.info(user.toString());
//		checking if the user already exists in the database
		if (getUserByEmail(user.getEmail()) != null) {
			return null;
		}
		
		if(user.getRoles() == null) {
			Set<Role> roles = new HashSet<>();
			roles.add(roleRepository.findById(2L).get());
			user.setRoles(roles);
		}
		

		return userRepository.save(user);
	}

	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	public User updateUserAdmin(User user, Long role_id) {
		User oldUser = userRepository.findById(user.getId()).get();
		
		Set<Role> roles = new HashSet<>();
		
		roles.add(roleRepository.findById(role_id).get());
		
		oldUser.setName(user.getName());
		oldUser.setCity(user.getCity());
		oldUser.setEmail(user.getEmail());
		oldUser.setPassword(user.getPassword());
		oldUser.setAddress(user.getAddress());
		oldUser.setState(user.getState());
		oldUser.setZipcode(user.getZipcode());
		oldUser.setCredit_card(user.getCredit_card());
		oldUser.setRoles(roles);
		return userRepository.save(oldUser);
	}
	
	public User updateUser(User user) {
		User oldUser = userRepository.findById(user.getId()).get();
		
		oldUser.setName(user.getName());
		oldUser.setCity(user.getCity());
		oldUser.setEmail(user.getEmail());
		oldUser.setAddress(user.getAddress());
		oldUser.setState(user.getState());
		oldUser.setZipcode(user.getZipcode());
		oldUser.setCredit_card(user.getCredit_card());
		return userRepository.save(oldUser);
		
	}

	public void deleteUser(Long id) {
		User user = userRepository.findById(id).get();
		logger.info(user.toString());
		userRepository.delete(user);
	}

}
