package com.spring.loan.controller;

import java.util.logging.Level; 
import java.util.logging.Logger;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.loan.entities.Admin;
import com.spring.loan.entities.User;
import com.spring.loan.service.UserService;

import io.swagger.annotations.ApiOperation;



@Validated

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserServiceController {
	Logger logger = Logger.getLogger(LoanAgreementController.class.getName());	
	
	public UserServiceController() {
		logger.log(Level.INFO,"----->Inside User Service Controller Working!");
	}
	
	@Autowired
	UserService userService;
	
	@PostMapping("/adduserasadmin")
	public Admin addNewUser(@RequestBody  @Valid Admin admin) {
		this.userService.addNewUser(admin);
		return admin;
		
	}
	
	@ApiOperation(value = "POST mapping to add new user to the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/signin")
	public User signIn(@RequestBody  @Valid User user) {
		this.userService.signIn(user);
		return user;
		
	}

	@ApiOperation(value = "POST mapping to logout from the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/signout")
	public User signOut(@RequestBody  @Valid User user) {
		this.userService.signOut(user);
		return user;
		
	}
}