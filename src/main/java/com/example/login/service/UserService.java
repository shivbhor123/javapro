package com.example.login.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.login.modul.User;
import com.example.login.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

	
	
	

}
