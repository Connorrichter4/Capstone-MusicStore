package com.hcl.capstone.services;

import java.util.List;
import java.util.Optional;

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
	
	public List<ShoppingCart> getAllItemsByUser(String email) {
		return cartRepository.findByUserName(email);
	}
	
	public Optional<ShoppingCart> getItemById(Long id) {
		return cartRepository.findById(id);
	}
	
	public ShoppingCart addItemToCart(ShoppingCart cart) {
		
		return cartRepository.save(cart);
	}
	
	public Boolean deleteItem(Long id) {
		if(getItemById(id).get() == null) {
			//throw new SongNotFoundException(id);
			return false;
		}else {
			cartRepository.delete(getItemById(id).get());
			return true;
		}
		
	}
	
	
	
}
