package com.hcl.capstone.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.Role;
import com.hcl.capstone.entities.User;
import com.hcl.capstone.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		
		User user = userRepository.findUserByEmail(email);
		logger.info(user.toString());
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	       
		System.out.println(user.getRoles().toString());
		for (Role role : user.getRoles())
		{
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	    }
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
	}

}
