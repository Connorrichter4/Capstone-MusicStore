package com.hcl.capstone.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		logger.info("inside configure - authentication manager");
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		 http.authorizeRequests()
		  .antMatchers("/admin/*").hasRole("ADMIN")
		  .antMatchers("/signup").permitAll()
		  .anyRequest().authenticated()
		  .and()
		    .formLogin().loginPage("/login").permitAll()
		  .and()
		    .logout().logoutSuccessUrl("/login?logout") 
		   .and()
		   .exceptionHandling().accessDeniedPage("/403")
		  .and()
		    .csrf();
	}
	
}
