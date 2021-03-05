package com.hcl.capstone.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.capstone.entities.Role;
import com.hcl.capstone.entities.User;
import com.hcl.capstone.repositories.RoleRepository;
import com.hcl.capstone.services.UserService;

@Component
public class UserInitializer {
	@Autowired
	private UserService userService;
	@Autowired
	RoleRepository roleRepo;
	
	@PostConstruct
	public void init() {
		
		Set<Role> roles = new HashSet<>();
		
		for( Role role : roleRepo.findAll()) {
			roles.add(role);
		}
		
		User admin = new User();
		
		admin.setEmail("admin@admin.com");
		admin.setPassword("password");
		admin.setRoles(roles);
		userService.createUser(admin);
		
		User user = new User();
		
		user.setEmail("user@user.com");
		user.setPassword("password");
		user.setAddress("1234 Apple St");
		user.setCity("New York");
		user.setName("user");
		user.setState("NY");
		userService.createUser(user);
		
		
	}
	
}
