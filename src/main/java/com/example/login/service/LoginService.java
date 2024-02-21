package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.login.modul.User;
import com.example.login.repository.UserRepository;

@Service
public class LoginService {
	 private final UserRepository userRepository;

    LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	 // Inject any necessary dependencies here

	    public boolean login(String email) {
	        // Add your validation logic here
	       User user =userRepository.findByEmail(email);
	       if(user!=null)
	       {
	    	   System.out.println("login Success");
	    	   return true;
	       }
	       else {
	    	   System.out.println("Error");
	    	   return false;
	       }
	    }

	    /*private boolean isValidEmail(String email) {
	        // Add your email validation logic here
	        // Return true if the email is valid, false otherwise
	    	return (email==email)?true:false;
	    }*/

	  
	}



