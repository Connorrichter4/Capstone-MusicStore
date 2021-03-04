package com.hcl.capstone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.ShoppingCart;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.entities.User;
import com.hcl.capstone.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository cartRepository;
	
	public ShoppingCart getAllItemsByUser(String email) {
		return cartRepository.findByUser(email);
	}
	
	public ShoppingCart addItemToCart(ShoppingCart cart) {
		
		return cartRepository.save(cart);
	}
	
	
	
	
}
