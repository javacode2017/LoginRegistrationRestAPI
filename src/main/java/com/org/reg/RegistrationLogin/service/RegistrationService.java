package com.org.reg.RegistrationLogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.reg.RegistrationLogin.model.User;
import com.org.reg.RegistrationLogin.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	public User fetchUSerByEmail(String emailId) {
		return userRepository.findByEmailId(emailId);
	}
	
	public User findUserByEmailAndPassword(String email,String password) {
		User userObj = userRepository.findByEmailIdAndPassword(email, password);
		return userObj;
	}
}
