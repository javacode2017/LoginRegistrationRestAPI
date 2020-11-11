package com.org.reg.RegistrationLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.reg.RegistrationLogin.model.User;
import com.org.reg.RegistrationLogin.service.RegistrationService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class RegisterController {

	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmailId();
		System.out.println("tempEmail is"+tempEmail);
		if(tempEmail != null &&  !"".equals(tempEmail)) {
			System.out.println(tempEmail);
			User userObj = registrationService.fetchUSerByEmail(tempEmail);
			if(userObj !=null) {
				System.out.println("userObj"+userObj.getEmailId());
				throw new Exception("User already exist with mailId");
			}
				
		}		
		User userObj = null;
		userObj = registrationService.registerUser(user);
		
		return userObj;
	}
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		System.out.println("angular call");
		String email = user.getEmailId();
		String password = user.getPassword();
		System.out.println("email and password"+email+""+password);
		User userObj = null;
		if (email !=null && password !=null) {
			System.out.println("email and password...."+email+""+password);
			userObj = registrationService.findUserByEmailAndPassword(email, password);
		}
		if(userObj == null) {
			throw new Exception("Bad Credentials ,User does not exist with Email"+email);
		}
		return userObj;
	}
	@GetMapping("/hello")
	@CrossOrigin(origins = "http://localhost:4200")
	public String hello() {
		return "response ok";
	}
	
	
}
