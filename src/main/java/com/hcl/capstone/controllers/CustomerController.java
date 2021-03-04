package com.hcl.capstone.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.capstone.entities.User;
import com.hcl.capstone.services.UserService;

@Controller
@RequestMapping("/admin")
public class CustomerController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserService userService;
	
	@GetMapping("/customers")
	public String showCustomers(ModelMap model) {
		Iterable<User> users = userService.getAll();
		model.put("users", users);
		return "admin-customers";
	}

	@GetMapping("/customer/{id}")
	public String getCustomer(ModelMap model, @PathVariable Long id) {
		User user = userService.getUserById(id);
		logger.info(user.toString());
		model.put("user", user);
		return "admin-edit-customer";
	}

	@PostMapping("/customer/{id}")
	public ModelAndView updateCustomer(ModelMap model, @PathVariable Long id, User user) {
		user.setId(id);
		// verify valid email using regex
		Pattern pattern = Pattern.compile(
				"^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(user.getEmail());
		System.out.println(matcher.matches());
		if (!matcher.matches()) {
			logger.info("Invalid Email Input");
			model.put("error", "Email Must Be Valid");
			return new ModelAndView("admin-edit-customer", model);
		}

		userService.updateUser(user);
		return new ModelAndView("redirect:/admin/customers");
	}

	@GetMapping("/customer/delete/{id}")
	public ModelAndView deleteCustomer(ModelMap model, @PathVariable Long id) {
		userService.deleteUser(id);
		return new ModelAndView("redirect:/admin/customers", model);
	}
}
