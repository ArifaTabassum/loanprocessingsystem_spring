package com.spring.loan.controller;

import java.time.LocalDate; 

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.spring.loan.entities.Customer;
import com.spring.loan.entities.LoanProgram;
import com.spring.loan.exception.CustomerNotFoundException;
import com.spring.loan.service.CustomerService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;


@Validated

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/v1")
@ApiModel(value = "Customer Service Rest Controller" , description = "Holds all APIs related to the customer")
public class CustomerServiceController {
	Logger logger = Logger.getLogger(CustomerServiceController.class.getName());
	@Autowired
	private CustomerService customerService;
	
	
	
	public CustomerServiceController() {
		logger.log(Level.INFO,"-----> Customer Rest Controller Working!");
		
	}

	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome to LOAN PROCESSING SYSTEM APPLICATION";
	}
	@ApiOperation(value = "GET mapping to get all loans from the database", response = List.class )
	@GetMapping("/viewallloans")
	public List<LoanProgram> viewAllLoanProgram(){
		return CustomerService.viewAllLoanProgram();
		
	}
	
	@ApiOperation(value = "POST mapping to add new customers to the LOAN_USER table in the Database", response = Customer.class)
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody @Valid Customer customer) {
		this.customerService.addCustomer(customer);
		return customer;
	}
	@ApiOperation(value = "GET mapping to view customers by entering the customer ID", response = Customer.class )	
	@GetMapping("/customers/{id}")
	public Customer viewCustomer(@PathVariable("id") int id) throws CustomerNotFoundException {
		return this.customerService.viewCustomer(id);
		
	}
	@ApiOperation(value = "PUT mapping to update customer details by customer ID", response = Customer.class )
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@RequestBody @Valid Customer customer) throws CustomerNotFoundException{
	return this.customerService.updateCustomer(customer);
		
	}
	@ApiOperation(value = "DELETE mapping to delete the customer from the LOAN_USER table by customer ID", response = Customer.class )
	@DeleteMapping("/customers/{id}")
	public Customer deleteCustomer(@PathVariable("id") int id) throws CustomerNotFoundException{
		return this.customerService.deleteCustomer(id);
		
	}
	@ApiOperation(value = "GET mapping to get all customers from the database", response = List.class )
	@GetMapping("/customers")
	public List<Customer> viewAllCustomers(){
		return this.customerService.viewAllCustomers();
		
	}
	@ApiOperation(value = "GET mapping to view all customers by date of application", response = List.class )
	@GetMapping("/viewbydate/{date}")
	public List<Customer> viewCustomerList(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dateOfApplication){
		return this.customerService.viewCustomerList(dateOfApplication);
		
	}

}