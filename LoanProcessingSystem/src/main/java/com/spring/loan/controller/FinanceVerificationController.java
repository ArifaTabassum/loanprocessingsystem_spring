package com.spring.loan.controller;

import java.util.logging.Level; 
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.loan.entities.LoanApplication;
import com.spring.loan.exception.InvalidLoanApplicationException;
import com.spring.loan.service.FinanceVerificationService;

import io.swagger.annotations.ApiOperation;

@Validated
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/financeverify")

public class FinanceVerificationController {
	Logger logger = Logger.getLogger(FinanceVerificationController.class.getName());
	@Autowired
	private FinanceVerificationService service;
	
	//Method to check the working of rest controller in the console
	public FinanceVerificationController() {
		logger.log(Level.INFO,"-----> Finance Rest Controller Working!");
		
	}
	
	//Method to check the connection with the webservice
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome :"
				+ ""; //returns String value
	}

	
	@ApiOperation(value="PUT mapping for the Finance Verification to update the status of application",response=FinanceVerificationController.class)
	@PutMapping("/financestatus")
	//Method to update the status of application and loan amount if approved, passes the parameters of application class
	public LoanApplication updateStatus(@RequestBody @Valid LoanApplication loanapplication) throws InvalidLoanApplicationException {
		
		return this.service.updateStatus(loanapplication);  //returns the updated loan application
	}

}