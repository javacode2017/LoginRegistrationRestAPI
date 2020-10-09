package com.org.reg.RegistrationLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.reg.RegistrationLogin.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	//User findByEmailId(String emailId);
	
	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId,String password);

	
 
 
}