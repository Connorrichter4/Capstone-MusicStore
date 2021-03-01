package com.hcl.capstone.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.capstone.entities.User;

@Controller
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String showSignUp() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public ModelAndView postSignUp(ModelMap model, User user) { // might have to change to modelmap
		logger.info(user.toString());
		
		return new ModelAndView("redirect:/", model);
	}
}
