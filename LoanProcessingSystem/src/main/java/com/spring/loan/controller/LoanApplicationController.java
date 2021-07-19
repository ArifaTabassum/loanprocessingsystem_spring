package com.spring.loan.controller;

import java.util.List; 
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.loan.entities.LoanApplication;
import com.spring.loan.exception.InvalidLoanApplicationException;
import com.spring.loan.service.LoanApplicationService;


import io.swagger.annotations.ApiOperation;




@Validated
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/v1")
public class LoanApplicationController {

	Logger logger = Logger.getLogger(LoanApplicationController.class.getName());

	public LoanApplicationController() {
		logger.log(Level.INFO, "----->Inside Loan Application Controller Working!");

	}

	@Autowired
	LoanApplicationService loanApplicationService;
	
	@GetMapping("/home1")
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)";
	}

	@PostMapping("/applications")
	public LoanApplication addLoanApplication(@RequestBody @Valid LoanApplication loanApplication) {
		this.loanApplicationService.addLoanApplication(loanApplication);
		return loanApplication;
	}

	@PutMapping("/update")
	public LoanApplication updateLoanApplication(@RequestBody @Valid LoanApplication loanApplication)
			throws InvalidLoanApplicationException {
		this.loanApplicationService.updateLoanApplication(loanApplication);
		return loanApplication;
	}

	@ApiOperation(value = "DELETE mapping to delete the application from LOAN_APPLICATION table by application ID in the Database", response = LoanApplication.class)
	@DeleteMapping("/delete/{applicationid}")
	public LoanApplication deleteLoanApplication(@PathVariable("applicationid") long loanApplicationId1)
			throws InvalidLoanApplicationException {
		return this.loanApplicationService.deleteLoanApplication(loanApplicationId1);

	}

	@ApiOperation(value = "GET mapping to view all the loan applications in the database ", response = List.class)
	@GetMapping("/applications")
	public List<LoanApplication> retrieveAllLoanApplication() {
		return this.loanApplicationService.retrieveAllLoanApplication();

	}

	@ApiOperation(value = "GET mapping to view all the loan applications by loan ID", response = LoanApplication.class)
	@GetMapping("/viewbyid/{loanid}")
	public LoanApplication retrieveLoanApplicationById(@PathVariable("loanid") long loanApplicationId)
			throws InvalidLoanApplicationException {
		return this.loanApplicationService.retrieveLoanApplicationById(loanApplicationId);

	}

}