package com.hcl.capstone.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hcl.capstone.entities.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
	public ShoppingCart findByUser(String email);
}
