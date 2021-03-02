package com.hcl.capstone.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.capstone.entities.User;
import com.hcl.capstone.services.UserService;

@Controller
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	@GetMapping("/signup")
	public String showSignUp() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public ModelAndView postSignUp(ModelMap model, User user, @RequestParam String password2 ) {
		logger.info(password2);
		logger.info(user.toString());
		if(!password2.equals(user.getPassword())) {
			logger.info("in password error");
			model.put("error", "Password Must Match");
			return new ModelAndView("/signup", model);
		} else if (user.getEmail() == "" || user.getPassword() == "") {
			model.put("error", "Please Fill Out All Fields");
			return new ModelAndView("/signup", model);
		}
		
		User newUser = userService.createUser(user);
		if(newUser != null) {
			model.put("user", newUser);
			return new ModelAndView("redirect:/", model);
		}
		model.put("error", "The User Email Already Exists!");
		return new ModelAndView("/signup", model);
	}
}
