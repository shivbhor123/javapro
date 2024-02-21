package com.example.login.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.login.modul.Role;
import com.example.login.modul.User;
import com.example.login.repository.UserRepository;
import com.example.login.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	
	@Override
	public User save(UserRegistrationDto registrationDto) {
		// TODO Auto-generated method stub
		
		
		User user =new User( registrationDto.getFirstname(),
				registrationDto.getLastname(),
				registrationDto.getEmail(),
				registrationDto.getPassword(),Arrays.asList(new Role("ROLE_USER")));
		 return userRepository.save(user);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user=userRepository.findByEmail(username);
	//	User pass= userRepository.findByPassword(password);
		if(user==null)
		{
			throw new UsernameNotFoundException("User not found with username: " + username);
			
		}
		
		Set<GrantedAuthority> authorities = new HashSet<>();
	    for (Role role : user.getRoles()) {
	        authorities.add(new SimpleGrantedAuthority(role.getName()));
	    }
		return new  org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
		
		
	}
	
	

}
