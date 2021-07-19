package com.spring.loan.UserServiceTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.spring.loan.entities.User;
import com.spring.loan.repository.UserRepository;
import com.spring.loan.service.UserServiceImpl;

/* User Service Junit Testing
 * Testing the condition by adding an Admin, in Admin we pass UserId, Password and Role.
 * Testing the condition by adding a Land Officer, in Land Officer we pass UserId, Password and Role. 
 * Testing the condition by adding a Finance Officer, in Finance Officer we pass UserId, Password and Role.
 * 
 * 
 * */

 class UserServiceTest {
	UserRepository userRepo;
	private static UserServiceImpl userService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
	      userRepo = mock(UserRepository.class); // test through approach 2
	      userService = new UserServiceImpl(userRepo); 	// Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	@Test
	//@Disabled
	@DisplayName("Add Admin as User")
	void addAdmin() {
	
		User input = new User();
		input.setUserId(2);
		input.setPassword("Helen");
		input.setRole("Admin");
 
		
		when(userRepo.save(input)).thenReturn(input);
	    User user_test = userService.addNewUser(input);
	    
	    
		assertEquals(input,user_test);
	}
	@Test
	//@Disabled
	@DisplayName("Add financeofficer as User")
	void addFinanceOfficer() {
	
		User input = new User();
		input.setUserId(2);
		input.setPassword("Anu");
		input.setRole("financeofficer");
        
		
		when(userRepo.save(input)).thenReturn(input);
	    User user_test = userService.addNewUser(input);
	    
	    
		assertEquals(input,user_test);
	}
	@Test
	//@Disabled
	@DisplayName("Add Landofficer as User")
	void addLandOfficer() {
	
		User input = new User();
		input.setUserId(2);
		input.setPassword("Sharath");
		input.setRole("Landofficer");
		
		when(userRepo.save(input)).thenReturn(input);
	    User user_test = userService.addNewUser(input);
	    
	    
		assertEquals(input,user_test);
	}

}