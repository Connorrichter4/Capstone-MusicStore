package com.hcl.capstone.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hcl.capstone.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findUserByEmail(String email);
	public List<User> findByRole(String role);
}
