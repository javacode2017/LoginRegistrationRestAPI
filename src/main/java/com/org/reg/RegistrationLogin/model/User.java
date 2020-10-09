package com.org.reg.RegistrationLogin.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
 
 @Id
 private int id;
 
 private String username;
 
 
 
 private String emailId;
 
 private String password;
 
 

public User() {
	super();
}



public User(int id, String username, String emailId, String password) {
	super();
	this.id = id;
	this.username = username;
	this.emailId = emailId;
	this.password = password;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public String getEmailId() {
	return emailId;
}



public void setEmailId(String emailId) {
	this.emailId = emailId;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}
 

 
 
 }