package com.hcl.capstone.controllers;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hcl.capstone.entities.ShoppingCart;
import com.hcl.capstone.entities.User;
import com.hcl.capstone.services.AlbumService;
import com.hcl.capstone.services.ShoppingCartService;
import com.hcl.capstone.services.SongService;
import com.hcl.capstone.services.UserService;

@Controller
public class ShoppingCartController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	ShoppingCartService cartService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SongService songService;
	
	@Autowired
	AlbumService albumService;
	
	
	@GetMapping("/cart")
	public String showShoppingCart(ModelMap model) {
		
		Iterable<ShoppingCart> cartItems = cartService.getAllItemsByUser("user@user.com");
		model.addAttribute("items", cartItems);
		model.addAttribute("user", userService.getUserByEmail("user@user.com"));
		
		BigDecimal total = new BigDecimal(0);
		
		for(ShoppingCart item: cartItems) {
			if(item.getAlbum() != null) {
				
				total = total.add(item.getAlbum().getPrice());
			} else if (item.getSong() != null) {
				
				total = total.add(item.getSong().getPrice());
			}
		}
		
		model.addAttribute("total", total);
		
		return "checkout-page";
	}
	
	@PostMapping("/cart")
	public ModelAndView shippingConfirmation(User user, @RequestParam(value = "gridCheck") String checkboxValue) {
		logger.info(user.toString());
		if(checkboxValue != null) {
			logger.info("saving user info");
		}
		return new ModelAndView("shipping-confirmation");
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
	
	@GetMapping("/cart/delete/{id}")
	public RedirectView removeItemFromCart(@PathVariable Long id ) {
		
		cartService.deleteItem(id);
		
		return new RedirectView("/cart");
	}
	
	
	
}
