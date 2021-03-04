package com.hcl.capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.hcl.capstone.entities.ShoppingCart;
import com.hcl.capstone.entities.User;
import com.hcl.capstone.services.AlbumService;
import com.hcl.capstone.services.ShoppingCartService;
import com.hcl.capstone.services.SongService;
import com.hcl.capstone.services.UserService;

@Controller
public class ShoppingCartController {

	@Autowired
	ShoppingCartService cartService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SongService songService;
	
	@Autowired
	AlbumService albumService;
	
//	@Autowired
//	ShoppingCart shoppingCart;
	
	@GetMapping("/cart")
	public String showShoppingCart(ModelMap model) {
		return "shopping-cart";
	}
	
	@GetMapping("/add/song/{id}")
	public RedirectView addSongToCart(@PathVariable Long id ) {
		ShoppingCart cart = new ShoppingCart();
		cart.setUser(userService.getUserById(1L));
		cart.setSong(songService.getSongById(id).get());
		cart.setAlbum(null);
		
		cartService.addItemToCart(cart);
		return new RedirectView("/album");
	}
	
	@GetMapping("/add/album/{id}")
	public RedirectView addAlbumToCart(@PathVariable Long id ) {
		ShoppingCart cart = new ShoppingCart();
		cart.setUser(userService.getUserById(1L));
		cart.setSong(null);
		cart.setAlbum(albumService.getAlbumById(id).get());
		
		cartService.addItemToCart(cart);
		
		return new RedirectView("/album");
	}
	
	
	
}
