package com.hcl.capstone.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hcl.capstone.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findOneUserByEmail(String email);
	
}
