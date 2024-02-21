package com.example.login.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.login.modul.Msg;
import com.example.login.modul.User;
import com.example.login.repository.MsgRepository;
import com.example.login.repository.UserRepository;
import com.example.login.service.LoginService;
import com.example.login.service.UserService;
import com.example.login.web.dto.UserRegistrationDto;



@Controller

public class UserRgistationController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	   // private LoginService loginService;*/

	
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto()
	{
		return new UserRegistrationDto();
	}
	@GetMapping("")
	public String ShowRegestrationForm(Model model)
	{
		model.addAttribute("User", new UserRegistrationDto());
		return "index";
	}
	@PostMapping("/register")
	public String RegisterUserAccount(UserRegistrationDto  userRgistationDto )
	{
		userService.save(userRgistationDto);
		System.out.println("data inserted succesfully");
		return "login";
	}
	 @PostMapping("/logins")
	    public String login(@RequestParam("email") String email, Model model) {
	        User user = userRepository.findByEmail(email);
	        if (user == null) {
	            model.addAttribute("error", "User not found");
	            return "login";
	        }
	        // Proceed with login process
	        // You can add further checks for password validation here
	        return "about"; // Redirect to dashboard upon successful login
	    }
	 @GetMapping("/signup")
	    public String showSignupPage() {
	        return "index"; // Assuming "signup.html" is your signup page
	    }
	 @GetMapping("/Navlogin")
	    public String NavloginshowSignupPage() {
	        return "login"; // Assuming "signup.html" is your signup page
	    }
	 @GetMapping("/Navabout")
	    public String NavAbout() {
	        return "index"; // Assuming "signup.html" is your signup page
	    }
	 @GetMapping("/Navco")
	    public String Navco() {
	        return "index"; // Assuming "signup.html" is your signup page
	    }
	 @GetMapping("/contact")
	    public String contact() {
	        return "login"; // Assuming "signup.html" is your signup page
	    }
	 @GetMapping("/about")
	    public String about() {
	        return "login"; // Assuming "signup.html" is your signup page
	    }
	
	 @GetMapping("/mabout")
	    public String mabout() {
	        return "about"; // Assuming "signup.html" is your signup page
	    }
	 @GetMapping("/mcontact")
	    public String mcontact() {
	        return "contact"; // Assuming "signup.html" is your signup page
	    }
	 
	 @GetMapping("/users")
	    public String getUsers(Model model) {
	        List<User> users = userRepository.findAll();
	        model.addAttribute("users", users);
	        return "displayuser"; // Assuming you have a Thymeleaf template called "userList.html"
	    }
	 @DeleteMapping("/deleteUser")
	    public ResponseEntity<String> deleteUser(@RequestParam("id") Long userId) {
	        userRepository.deleteById(userId);
	        return ResponseEntity.ok("User deleted successfully");
	    }
	
	
	 /*@PostMapping("/login")
	    public String processLoginForm(@RequestParam("email") String email, Model model) {
	        // Call the login service to validate the login credentials
	        String loginMessage = loginService.login(email);

	        // Add the login message to the model to display it in the view
	        model.addAttribute("loginMessage", loginMessage);

	        // Add any additional logic or redirect to a success page
	        return "login-success";
	    }*/
	/*@PostMapping("/logins")
	public String processLoginForm(@RequestParam("email") String email) {
	    // Call the login service to validate the login credentials
	    boolean loginSuccessful = loginService.login(email);

	    if (loginSuccessful) {
	        // Add any additional logic or redirect to a success page
	    	System.out.println("login sucessfully");
	        return "Login-success";
	    } else {
	        // Add an error message to the model to display it in the view
	       // model.addAttribute("errorMessage", "Invalid email or password");

	        // Return the login form again
	        System.out.println("login unsucessfully");
	        return "login";
	    }
	}*/
	
	//*******************************************************************************
	/*@GetMapping("")
	public String showHome(Model  model)
	{
		model.addAttribute("user", new User());
		
	return "index";	
	}
	@PostMapping("/register")
	public String showLoginpage(User user) 
	{
		repo.save(user);
		System.out.println("Insert Data Succesfully........");
		return "login";
	}
*/
	 
	 //contact us controller
	 @Autowired
	    private MsgRepository msgg;
	 
	 @GetMapping("/contactus")
	    public String showContactPage() {
	        return "contact";
	    }

	    @PostMapping("/submit-message")
	    public String submitMessage(Msg msg) 
	    {
	        
	            msgg.save(msg);
	            System.out.println("Data insert Succesfully");
	            return "contact";
	           
	        
	    }
}
