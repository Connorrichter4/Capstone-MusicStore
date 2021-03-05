package com.hcl.capstone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.hcl.capstone.entities.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
	@Query("SELECT shoppingcart FROM ShoppingCart shoppingcart WHERE shoppingcart.user.email = :email")
	public List<ShoppingCart> findByUserName(@Param("email") String email);
}
